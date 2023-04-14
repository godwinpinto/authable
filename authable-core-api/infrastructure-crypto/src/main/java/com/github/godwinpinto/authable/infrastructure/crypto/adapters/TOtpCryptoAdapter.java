package com.github.godwinpinto.authable.infrastructure.crypto.adapters;

import com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpCryptoSPI;
import com.github.godwinpinto.authable.infrastructure.crypto.service.TOtpSecretEncryption;
import com.github.godwinpinto.authable.infrastructure.crypto.service.TOtpService;

public class TOtpCryptoAdapter implements TOtpCryptoSPI {

    private TOtpService tOtpService;

    private TOtpSecretEncryption tOtpSecretEncryption;

    public TOtpCryptoAdapter(TOtpService tOtpService, TOtpSecretEncryption tOtpSecretEncryption) {
        this.tOtpService = tOtpService;
        this.tOtpSecretEncryption = tOtpSecretEncryption;
    }

    public String generateSecretKey(String userId) {
        return tOtpService.generateSecretKey(userId);
    }

    public String getPlainTextSecret(String userId, String encryptedSecret) {
        return tOtpSecretEncryption.decrypt(userId, encryptedSecret);
    }

    public Boolean verify(String plainTextOtp, String userId, String encryptedSecret) {
        return tOtpService.verify(plainTextOtp, userId, encryptedSecret);
    }

    public String generateQRCode(String userId, String encryptedSecret, String email, String appName) {
        try {
            return tOtpService.generateQRCode(userId, encryptedSecret, email, appName);
        } catch (Exception e) {
            return "";
        }
    }
}
