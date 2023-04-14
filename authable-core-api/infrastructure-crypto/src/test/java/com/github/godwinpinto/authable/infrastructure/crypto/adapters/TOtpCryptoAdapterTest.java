package com.github.godwinpinto.authable.infrastructure.crypto.adapters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.github.godwinpinto.authable.infrastructure.crypto.service.TOtpSecretEncryption;
import com.github.godwinpinto.authable.infrastructure.crypto.service.TOtpService;
import dev.samstevens.totp.exceptions.QrGenerationException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TOtpCryptoAdapterTest {
    /**
     * Method under test: {@link TOtpCryptoAdapter#TOtpCryptoAdapter(TOtpService, TOtpSecretEncryption)}
     */
    @Test
    void testConstructor() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     TOtpCryptoAdapter.tOtpSecretEncryption
        //     TOtpCryptoAdapter.tOtpService

        TOtpService tOtpService = mock(TOtpService.class);
        new TOtpCryptoAdapter(tOtpService, new TOtpSecretEncryption());

    }

    /**
     * Method under test: {@link TOtpCryptoAdapter#generateSecretKey(String)}
     */
    @Test
    void testGenerateSecretKey() {
        TOtpService tOtpService = mock(TOtpService.class);
        when(tOtpService.generateSecretKey(Mockito.<String>any())).thenReturn("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
        assertEquals("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
                (new TOtpCryptoAdapter(tOtpService, new TOtpSecretEncryption())).generateSecretKey("42"));
        verify(tOtpService).generateSecretKey(Mockito.<String>any());
    }

    /**
     * Method under test: {@link TOtpCryptoAdapter#getPlainTextSecret(String, String)}
     */
    @Test
    void testGetPlainTextSecret() {
        TOtpService tOtpService = mock(TOtpService.class);
        assertNull((new TOtpCryptoAdapter(tOtpService, new TOtpSecretEncryption())).getPlainTextSecret("42",
                "Encrypted Secret"));
    }

    /**
     * Method under test: {@link TOtpCryptoAdapter#getPlainTextSecret(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetPlainTextSecret2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.github.godwinpinto.authable.infrastructure.crypto.service.TOtpSecretEncryption.decrypt(String, String)" because "this.tOtpSecretEncryption" is null
        //       at com.github.godwinpinto.authable.infrastructure.crypto.adapters.TOtpCryptoAdapter.getPlainTextSecret(TOtpCryptoAdapter.java:23)
        //   See https://diff.blue/R013 to resolve this issue.

        (new TOtpCryptoAdapter(mock(TOtpService.class), null)).getPlainTextSecret("42", "Encrypted Secret");
    }

    /**
     * Method under test: {@link TOtpCryptoAdapter#getPlainTextSecret(String, String)}
     */
    @Test
    void testGetPlainTextSecret3() {
        TOtpService tOtpService = mock(TOtpService.class);
        assertNull((new TOtpCryptoAdapter(tOtpService, new TOtpSecretEncryption()))
                .getPlainTextSecret("PBKDF2WithHmacSHA256", "Encrypted Secret"));
    }

    /**
     * Method under test: {@link TOtpCryptoAdapter#verify(String, String, String)}
     */
    @Test
    void testVerify() {
        TOtpService tOtpService = mock(TOtpService.class);
        when(tOtpService.verify(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(true);
        assertTrue((new TOtpCryptoAdapter(tOtpService, new TOtpSecretEncryption())).verify("Plain Text Otp", "42",
                "Encrypted Secret"));
        verify(tOtpService).verify(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());
    }

    /**
     * Method under test: {@link TOtpCryptoAdapter#verify(String, String, String)}
     */
    @Test
    void testVerify2() {
        TOtpService tOtpService = mock(TOtpService.class);
        when(tOtpService.verify(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(false);
        assertFalse((new TOtpCryptoAdapter(tOtpService, new TOtpSecretEncryption())).verify("Plain Text Otp", "42",
                "Encrypted Secret"));
        verify(tOtpService).verify(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());
    }

    /**
     * Method under test: {@link TOtpCryptoAdapter#generateQRCode(String, String, String, String)}
     */
    @Test
    void testGenerateQRCode() throws QrGenerationException {
        TOtpService tOtpService = mock(TOtpService.class);
        when(tOtpService.generateQRCode(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any(),
                Mockito.<String>any())).thenReturn("Generate QRCode");
        assertEquals("Generate QRCode", (new TOtpCryptoAdapter(tOtpService, new TOtpSecretEncryption()))
                .generateQRCode("42", "Encrypted Secret", "jane.doe@example.org", "App Name"));
        verify(tOtpService).generateQRCode(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any(),
                Mockito.<String>any());
    }
}

