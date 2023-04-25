package com.github.godwinpinto.authable.infrastructure.crypto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@Import(TOtpSecretEncryption.class)
@TestPropertySource(properties = {"infrastructure-crypto.totp.secret-key=12345678901234561234567890123456"})
class SecretEncryptionTest {

  @Autowired private TOtpSecretEncryption tOtpSecretEncryption;

  private MockedStatic<Cipher> mockedStatic;

  @Test
  void validateEncryptionDecryptionTest() {
    String data = "hello";
    String salt = "ask";

    String encryptedData = tOtpSecretEncryption.encrypt(salt, data);
    String decryptedData = tOtpSecretEncryption.decrypt(salt, encryptedData);
    assertEquals(data, decryptedData);
  }

  @Test
  void encryptionExceptionTest() throws NoSuchAlgorithmException, NoSuchPaddingException {
    String data = "hello";
    String salt = "ask";

    mockedStatic = mockStatic(Cipher.class);
    when(Cipher.getInstance(anyString())).thenThrow(new NoSuchAlgorithmException());

    assertNull(tOtpSecretEncryption.encrypt(salt, data), "Got correct null");

    mockedStatic.close();
  }

  @Test
  void decryptionExceptionTest() throws NoSuchAlgorithmException, NoSuchPaddingException {
    String data = "hello";
    String salt = "ask";
    String encryptedData = tOtpSecretEncryption.encrypt(salt, data);

    mockedStatic = mockStatic(Cipher.class);
    when(Cipher.getInstance(anyString())).thenThrow(new NoSuchAlgorithmException());

    assertNull(tOtpSecretEncryption.decrypt(salt, encryptedData), "Got correct null");
    mockedStatic.close();
  }
}
