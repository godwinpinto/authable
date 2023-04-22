package com.github.godwinpinto.authable.infrastructure.crypto.adapters;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.github.godwinpinto.authable.commons.exception.NonFatalException;
import com.github.godwinpinto.authable.infrastructure.crypto.service.TOtpSecretEncryption;
import com.github.godwinpinto.authable.infrastructure.crypto.service.TOtpService;
import dev.samstevens.totp.exceptions.QrGenerationException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TOtpCryptoAdapterTest {

  @Test
  void testConstructor() {
    TOtpService tOtpService = mock(TOtpService.class);
    new TOtpCryptoAdapter(tOtpService, new TOtpSecretEncryption());
  }

  @Test
  void testGenerateSecretKey() throws NonFatalException {
    TOtpService tOtpService = mock(TOtpService.class);
    when(tOtpService.generateSecretKey(Mockito.<String>any()))
        .thenReturn("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
    assertEquals(
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
        (new TOtpCryptoAdapter(tOtpService, new TOtpSecretEncryption())).generateSecretKey("42"));
    verify(tOtpService).generateSecretKey(Mockito.<String>any());
  }

  @Test
  void testGetPlainTextSecret() {
    TOtpService tOtpService = mock(TOtpService.class);
    assertNull(
        (new TOtpCryptoAdapter(tOtpService, new TOtpSecretEncryption()))
            .getPlainTextSecret("42", "Encrypted Secret"));
  }

  @Test
  void testGetPlainTextSecret3() {
    TOtpService tOtpService = mock(TOtpService.class);
    assertNull(
        (new TOtpCryptoAdapter(tOtpService, new TOtpSecretEncryption()))
            .getPlainTextSecret("PBKDF2WithHmacSHA256", "Encrypted Secret"));
  }

  @Test
  void testVerify() {
    TOtpService tOtpService = mock(TOtpService.class);
    when(tOtpService.verify(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(true);
    assertTrue(
        (new TOtpCryptoAdapter(tOtpService, new TOtpSecretEncryption()))
            .verify("Plain Text Otp", "42", "Encrypted Secret"));
    verify(tOtpService).verify(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());
  }

  @Test
  void testVerify2() {
    TOtpService tOtpService = mock(TOtpService.class);
    when(tOtpService.verify(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(false);
    assertFalse(
        (new TOtpCryptoAdapter(tOtpService, new TOtpSecretEncryption()))
            .verify("Plain Text Otp", "42", "Encrypted Secret"));
    verify(tOtpService).verify(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());
  }

  @Test
  void testGenerateQRCode() throws NonFatalException, QrGenerationException {
    TOtpService tOtpService = mock(TOtpService.class);
    when(tOtpService.generateQRCode(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any()))
        .thenReturn("Generate QRCode");
    assertEquals(
        "Generate QRCode",
        (new TOtpCryptoAdapter(tOtpService, new TOtpSecretEncryption()))
            .generateQRCode("42", "Encrypted Secret", "jane.doe@example.org", "App Name"));
    verify(tOtpService)
        .generateQRCode(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any());
  }

  @Test
  void secretKeyFailureTest() throws NonFatalException {
    TOtpService tOtpService = mock(TOtpService.class);
    when(tOtpService.generateSecretKey(anyString()))
        .thenThrow(new NonFatalException("User Id blank"));
    assertEquals(
        "", (new TOtpCryptoAdapter(tOtpService, new TOtpSecretEncryption())).generateSecretKey(""));
  }

  @Test
  void generateQRCodeFailureTest() throws NonFatalException, QrGenerationException {
    TOtpService tOtpService = mock(TOtpService.class);
    when(tOtpService.generateQRCode(anyString(), anyString(), anyString(), anyString()))
        .thenThrow(new NonFatalException("Fields Empty"));
    assertEquals(
        "",
        (new TOtpCryptoAdapter(tOtpService, new TOtpSecretEncryption()))
            .generateQRCode("", "", "", ""));
  }
}
