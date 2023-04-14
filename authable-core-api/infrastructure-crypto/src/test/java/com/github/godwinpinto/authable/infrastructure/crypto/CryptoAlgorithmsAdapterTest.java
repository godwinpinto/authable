package com.github.godwinpinto.authable.infrastructure.crypto;


import com.github.godwinpinto.authable.infrastructure.crypto.adapters.CryptoAlgorithmsAdapter;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class CryptoAlgorithmsAdapterTest {

    @Test
    public void generateHashFromString_Test() {

        CryptoAlgorithmsAdapter cryptoAlgorithmsAdapter = new CryptoAlgorithmsAdapter();

        assertDoesNotThrow(() -> {
            String generateHash = cryptoAlgorithmsAdapter.generateHashFromSecret("NETBK", "TESTUSER", "Test@1234");

        });
    }

    @Test
    public void validateHashFromSecret_Success_Test() {

        CryptoAlgorithmsAdapter cryptoAlgorithmsAdapter = new CryptoAlgorithmsAdapter();

        String hashedData =
                "e6baee1adf05c0b6fadb73327a5b7360be9695c99a06a8451cf8cce63d39ab0ec10ed5aa62273ce644a80dec403873a2d329a532429e798c22df217b22e2155a";
        String generateHash = cryptoAlgorithmsAdapter
                .generateHashFromSecret("NETBK", "TESTUSER", "Test@1234");
        assertEquals(hashedData, generateHash);
    }

    @Test

    public void validateHashFromSecret_NoSuchAlgorithm_Test() throws NoSuchAlgorithmException {

        CryptoAlgorithmsAdapter cryptoAlgorithmsAdapter = new CryptoAlgorithmsAdapter();
        Mockito.mockStatic(MessageDigest.class);
        when(MessageDigest.getInstance(anyString())).thenThrow(new NoSuchAlgorithmException());
        System.out.println("212");
        Exception exception = assertThrows(RuntimeException.class, () -> {
            cryptoAlgorithmsAdapter.generateHashFromSecret("NETBK", "TESTUSER", "Test@1234");
        });
        String expectedMessage = "NoSuchAlgorithmException";
        String actualMessage = exception.getMessage();
        System.out.println(actualMessage);

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
