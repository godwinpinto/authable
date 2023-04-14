package com.github.godwinpinto.authable.infrastructure.crypto;

import com.github.godwinpinto.authable.infrastructure.crypto.service.TOtpSecretEncryption;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@Import(TOtpSecretEncryption.class)
@TestPropertySource(properties = {"infrastructure-crypto.totp.secret-key=1234567890123456"})
public class SecretEncryptionTest {

    @Autowired
    private TOtpSecretEncryption tOtpSecretEncryption;


    @Test
    public void validateEncryptionDecryptionTest() {
        String data = "hello";
        String salt = "ask";

        String encryptedData = tOtpSecretEncryption.encrypt(salt, data);
        String decryptedData = tOtpSecretEncryption.decrypt(salt, encryptedData);
        assertEquals(data, decryptedData);
    }

}
