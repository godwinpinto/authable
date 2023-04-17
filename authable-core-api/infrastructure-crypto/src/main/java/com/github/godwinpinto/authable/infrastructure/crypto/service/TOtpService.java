package com.github.godwinpinto.authable.infrastructure.crypto.service;

import dev.samstevens.totp.code.CodeGenerator;
import dev.samstevens.totp.code.DefaultCodeGenerator;
import dev.samstevens.totp.code.DefaultCodeVerifier;
import dev.samstevens.totp.code.HashingAlgorithm;
import dev.samstevens.totp.exceptions.QrGenerationException;
import dev.samstevens.totp.qr.QrData;
import dev.samstevens.totp.qr.QrGenerator;
import dev.samstevens.totp.qr.ZxingPngQrGenerator;
import dev.samstevens.totp.time.SystemTimeProvider;
import dev.samstevens.totp.time.TimeProvider;
import dev.samstevens.totp.util.Utils;
import org.apache.commons.codec.binary.Base32;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class TOtpService {

    @Value("${infrastructure-crypto.totp.time-period}")
    private int allowedTimePeriod;

    @Value("${infrastructure-crypto.totp.allowed-discrepancy}")
    private int allowedDiscrepancy;

    private TOtpSecretEncryption tOtpSecretEncryption;

    TOtpService(TOtpSecretEncryption tOtpSecretEncryption) {
        this.tOtpSecretEncryption = tOtpSecretEncryption;
    }

    public String generateSecretKey(String userId) {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[20];
        random.nextBytes(bytes);
        Base32 base32 = new Base32();
        return tOtpSecretEncryption.encrypt(userId, base32.encodeToString(bytes));
    }

    public Boolean verify(String plainTextOtp, String userId, String encryptedSecret) {
        TimeProvider timeProvider = new SystemTimeProvider();
        CodeGenerator codeGenerator = new DefaultCodeGenerator();
        DefaultCodeVerifier verifier = new DefaultCodeVerifier(codeGenerator, timeProvider);
        // sets the time period for codes to be valid for to 60 seconds
        verifier.setTimePeriod(allowedTimePeriod);
        // allow codes valid for 2 time periods before/after to pass as valid
        verifier.setAllowedTimePeriodDiscrepancy(allowedDiscrepancy);
        String userPlainTextSecret = tOtpSecretEncryption.decrypt(userId, encryptedSecret);
        return verifier.isValidCode(userPlainTextSecret, plainTextOtp);
    }

    public String generateQRCode(String userId, String encryptedSecret, String email, String appName) throws QrGenerationException {
        String userPlainTextSecret = tOtpSecretEncryption.decrypt(userId, encryptedSecret);
        QrData data = new QrData.Builder()
                .label(email)
                .secret(userPlainTextSecret)

                .issuer(appName)
                .algorithm(HashingAlgorithm.SHA1) // More on this below
                .digits(6)
                .period(allowedTimePeriod)
                .build();

        QrGenerator generator = new ZxingPngQrGenerator();
        byte[] imageData = generator.generate(data);
        String mimeType = generator.getImageMimeType();
        return Utils.getDataUriForImage(imageData, mimeType);
    }
}
