package com.github.godwinpinto.authable.infrastructure.crypto.adapters;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class CryptoAlgorithmsAdapterTest {

  @Test
  void generateHashFromString_Test() {

    CryptoAlgorithmsAdapter cryptoAlgorithmsAdapter = new CryptoAlgorithmsAdapter();

    assertDoesNotThrow(
        () -> {
          String generateHash =
              cryptoAlgorithmsAdapter.generateHashFromSecret("NETBK", "TESTUSER", "Test@1234");
        });
  }

  @Test
  void validateHashFromSecret_Success_Test() {

    CryptoAlgorithmsAdapter cryptoAlgorithmsAdapter = new CryptoAlgorithmsAdapter();

    String hashedData =
        "e6baee1adf05c0b6fadb73327a5b7360be9695c99a06a8451cf8cce63d39ab0ec10ed5aa62273ce644a80dec403873a2d329a532429e798c22df217b22e2155a";
    String generateHash =
        cryptoAlgorithmsAdapter.generateHashFromSecret("NETBK", "TESTUSER", "Test@1234");
    assertEquals(hashedData, generateHash);
  }

  @Test
  void validateHashFromSecret_NoSuchAlgorithm_Test() throws NoSuchAlgorithmException {

    CryptoAlgorithmsAdapter cryptoAlgorithmsAdapter = new CryptoAlgorithmsAdapter();
    MockedStatic<MessageDigest> md = Mockito.mockStatic(MessageDigest.class);
    when(MessageDigest.getInstance(anyString())).thenThrow(new NoSuchAlgorithmException());
    assertEquals(
        "", cryptoAlgorithmsAdapter.generateHashFromSecret("NETBK", "TESTUSER", "Test@1234"));
    md.close();
  }
}
