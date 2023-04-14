package com.github.godwinpinto.authable.infrastructure.crypto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import dev.samstevens.totp.exceptions.QrGenerationException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TOtpService.class})
@ExtendWith(SpringExtension.class)
class TOtpServiceTest {
    @Autowired
    private TOtpService tOtpService;

    /**
     * Method under test: {@link TOtpService#generateSecretKey(String)}
     */
    @Test
    void testGenerateSecretKey() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.infrastructure.crypto.service.TOtpService.allowedTimePeriod
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        assertNull((new TOtpService(new TOtpSecretEncryption())).generateSecretKey("42"));
        assertNull((new TOtpService(new TOtpSecretEncryption())).generateSecretKey("PBKDF2WithHmacSHA256"));
    }

    /**
     * Method under test: {@link TOtpService#generateSecretKey(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGenerateSecretKey2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.infrastructure.crypto.service.TOtpService.allowedTimePeriod
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.github.godwinpinto.authable.infrastructure.crypto.service.TOtpSecretEncryption.encrypt(String, String)" because "this.tOtpSecretEncryption" is null
        //       at com.github.godwinpinto.authable.infrastructure.crypto.service.TOtpService.generateSecretKey(TOtpService.java:40)
        //   See https://diff.blue/R013 to resolve this issue.

        (new TOtpService(null)).generateSecretKey("42");
    }

    /**
     * Method under test: {@link TOtpService#generateSecretKey(String)}
     */
    @Test
    void testGenerateSecretKey3() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.infrastructure.crypto.service.TOtpService.allowedTimePeriod
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        TOtpSecretEncryption tOtpSecretEncryption = mock(TOtpSecretEncryption.class);
        when(tOtpSecretEncryption.encrypt(Mockito.<String>any(), Mockito.<String>any())).thenReturn("Encrypt");
        assertEquals("Encrypt", (new TOtpService(tOtpSecretEncryption)).generateSecretKey("42"));
        verify(tOtpSecretEncryption).encrypt(Mockito.<String>any(), Mockito.<String>any());
    }

    /**
     * Method under test: {@link TOtpService#verify(String, String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testVerify() {
        // TODO: Complete this test.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.infrastructure.crypto.service.TOtpService.allowedTimePeriod
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        // Arrange
        // TODO: Populate arranged inputs
        String plainTextOtp = "";
        String userId = "";
        String encryptedSecret = "";

        // Act
        Boolean actualVerifyResult = this.tOtpService.verify(plainTextOtp, userId, encryptedSecret);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link TOtpService#generateQRCode(String, String, String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGenerateQRCode() throws QrGenerationException {
        // TODO: Complete this test.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.infrastructure.crypto.service.TOtpService.allowedTimePeriod
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        // Arrange
        // TODO: Populate arranged inputs
        String userId = "";
        String encryptedSecret = "";
        String email = "";
        String appName = "";

        // Act
        String actualGenerateQRCodeResult = this.tOtpService.generateQRCode(userId, encryptedSecret, email, appName);

        // Assert
        // TODO: Add assertions on result
    }
}

