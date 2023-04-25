package com.github.godwinpinto.authable.infrastructure.crypto.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.github.godwinpinto.authable.commons.exception.NonFatalException;
import dev.samstevens.totp.code.CodeGenerator;
import dev.samstevens.totp.code.DefaultCodeGenerator;
import dev.samstevens.totp.code.HashingAlgorithm;
import dev.samstevens.totp.exceptions.CodeGenerationException;
import dev.samstevens.totp.exceptions.QrGenerationException;
import dev.samstevens.totp.time.SystemTimeProvider;
import dev.samstevens.totp.time.TimeProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TOtpService.class})
@ExtendWith(SpringExtension.class)
@TestPropertySource(
    properties = {
      "infrastructure-crypto.totp.time-period=30",
      "infrastructure-crypto.totp.allowed-discrepancy=2"
    })
class TOtpServiceTest {
  @MockBean TOtpSecretEncryption tOtpSecretEncryption;
  @Autowired private TOtpService tOtpService;

  @Test
  void generateSecretKeyTest() throws NonFatalException {
    when(tOtpSecretEncryption.encrypt(anyString(), anyString())).thenReturn("OK");
    String key = tOtpService.generateSecretKey("TESTUSER");
    assertEquals("OK", key);
  }

  @Test
  void generateSecretKeyEmptyStringTest() throws NonFatalException {
    when(tOtpSecretEncryption.encrypt("", "")).thenReturn("");
    assertThrows(NonFatalException.class, () -> tOtpService.generateSecretKey(""));
    assertThrows(NonFatalException.class, () -> tOtpService.generateSecretKey(null));
  }

  @Test
  void verifyOtpEmptyFieldsTest() throws NonFatalException {
    assertEquals(false, tOtpService.verify(null, null, null));
    assertEquals(false, tOtpService.verify(null, "TESTUSER", "BLAHBLAH"));
    assertEquals(false, tOtpService.verify("123456", null, "BLAHBLAH"));
    assertEquals(false, tOtpService.verify("123456", "TESTUSER", null));
  }

  @Test
  void verifyOtpSuccessTest() throws NonFatalException, CodeGenerationException {
    TimeProvider timeProvider = new SystemTimeProvider();
    CodeGenerator codeGenerator = new DefaultCodeGenerator();
    String code =
        generateCode(
            HashingAlgorithm.SHA1, "SNMW5MPTK6IBHA4SMBWW5DBLMICMKOP2", timeProvider.getTime());
    when(tOtpSecretEncryption.decrypt(anyString(), anyString()))
        .thenReturn("SNMW5MPTK6IBHA4SMBWW5DBLMICMKOP2");
    assertEquals(true, tOtpService.verify(code, "TESTUSER", "BLAHBLAH"));
  }

  private String generateCode(HashingAlgorithm algorithm, String secret, long time)
      throws CodeGenerationException {
    long currentBucket = Math.floorDiv(time, 30);
    DefaultCodeGenerator g = new DefaultCodeGenerator(algorithm);
    return g.generate(secret, currentBucket);
  }

  @Test
  void verifyOtpFailedTest() throws NonFatalException, CodeGenerationException {
    String code = "122345";
    when(tOtpSecretEncryption.decrypt(anyString(), anyString()))
        .thenReturn("SNMW5MPTK6IBHA4SMBWW5DBLMICMKOP2");
    assertEquals(false, tOtpService.verify(code, "TESTUSER", "BLAHBLAH"));
  }

  @Test
  void generateQRSuccessTest()
      throws NonFatalException, CodeGenerationException, QrGenerationException {
    String SECRET = "SNMW5MPTK6IBHA4SMBWW5DBLMICMKOP2";

    when(tOtpSecretEncryption.decrypt(anyString(), anyString()))
        .thenReturn("SNMW5MPTK6IBHA4SMBWW5DBLMICMKOP2");
    assertDoesNotThrow(
        () -> tOtpService.generateQRCode("TESETUSER", "BLAHBLAH", "test@test.com", "TestApp"));
  }

  @Test
  void generateQRFailedTest()
      throws NonFatalException, CodeGenerationException, QrGenerationException {
    String SECRET = "SNMW5MPTK6IBHA4SMBWW5DBLMICMKOP2";

    when(tOtpSecretEncryption.decrypt(anyString(), anyString()))
        .thenReturn("SNMW5MPTK6IBHA4SMBWW5DBLMICMKOP2");
    assertThrows(
        NonFatalException.class,
        () -> tOtpService.generateQRCode("", "BLAHBLAH", "test@test.com", "TestApp"));
    assertThrows(
        NonFatalException.class,
        () -> tOtpService.generateQRCode("TESETUSER", "", "test@test.com", "TestApp"));
    assertThrows(
        NonFatalException.class,
        () -> tOtpService.generateQRCode("TESETUSER", "BLAHBLAH", "", "TestApp"));
    assertThrows(
        NonFatalException.class,
        () -> tOtpService.generateQRCode("TESETUSER", "BLAHBLAH", "test@test.com", ""));

    when(tOtpSecretEncryption.decrypt(anyString(), anyString())).thenReturn("");

    assertThrows(
        NonFatalException.class,
        () -> tOtpService.generateQRCode("TESETUSER", "BLAHBLAH", "test@test.com", "TestApp"));
  }
}
