package com.github.godwinpinto.authable.domain.totp.usecase;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.anyShort;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.github.godwinpinto.authable.domain.totp.dto.TOtpUserMasterDto;
import com.github.godwinpinto.authable.domain.totp.dto.TOtpVerifyDto;
import com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpCryptoSPI;
import com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpUserMasterSPI;

import java.time.LocalDateTime;
import java.util.function.Function;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;

@ContextConfiguration(classes = {TOtpVerifyHelper.class})
@ExtendWith(SpringExtension.class)
class TOtpVerifyHelperTest {
    @Autowired
    private TOtpVerifyHelper tOtpVerifyHelper;

    /**
     * Method under test: {@link TOtpVerifyHelper#isUserNotActive(TOtpUserMasterDto)}
     */
    @Test
    void testIsUserNotActive() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.domain.totp.usecase.TOtpVerifyHelper.maxFailedAttempts
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        TOtpVerifyHelper tOtpVerifyHelper = new TOtpVerifyHelper(null, null);
        TOtpUserMasterDto user = mock(TOtpUserMasterDto.class);
        when(user.getStatus()).thenReturn("Status");
        tOtpVerifyHelper.isUserNotActive(user);
        verify(user).getStatus();
    }

    /**
     * Method under test: {@link TOtpVerifyHelper#isUserNotActive(TOtpUserMasterDto)}
     */
    @Test
    void testIsUserNotActive2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.domain.totp.usecase.TOtpVerifyHelper.maxFailedAttempts
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        TOtpVerifyHelper tOtpVerifyHelper = new TOtpVerifyHelper(null, null);
        TOtpUserMasterDto user = mock(TOtpUserMasterDto.class);
        when(user.getStatus()).thenReturn("N");
        tOtpVerifyHelper.isUserNotActive(user);
        verify(user).getStatus();
    }

    /**
     * Method under test: {@link TOtpVerifyHelper#formatNoSubscriptionMessage()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFormatNoSubscriptionMessage() {
        // TODO: Complete this test.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.domain.totp.usecase.TOtpVerifyHelper.maxFailedAttempts
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        // Arrange and Act
        // TODO: Populate arranged inputs
        Mono<TOtpVerifyDto> actualFormatNoSubscriptionMessageResult =
                this.tOtpVerifyHelper.formatNoSubscriptionMessage();

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link TOtpVerifyHelper#fallbackMethod(Throwable)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFallbackMethod() {
        // TODO: Complete this test.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.domain.totp.usecase.TOtpVerifyHelper.maxFailedAttempts
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        // Arrange
        // TODO: Populate arranged inputs
        Throwable error = null;

        // Act
        Mono<TOtpVerifyDto> actualFallbackMethodResult = this.tOtpVerifyHelper.fallbackMethod(error);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link TOtpVerifyHelper#verifyAndUpdateOtp(String, String, TOtpUserMasterDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testVerifyAndUpdateOtp() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.domain.totp.usecase.TOtpVerifyHelper.maxFailedAttempts
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpCryptoSPI.verify(String, String, String)" because "this.tOtpCryptoSPI" is null
        //       at com.github.godwinpinto.authable.domain.totp.usecase.TOtpVerifyHelper.verifyAndUpdateOtp(TOtpVerifyHelper.java:65)
        //   See https://diff.blue/R013 to resolve this issue.

        TOtpVerifyHelper tOtpVerifyHelper = new TOtpVerifyHelper(null, null);
        TOtpUserMasterDto user = mock(TOtpUserMasterDto.class);
        when(user.getUserSecret()).thenReturn("User Secret");
        tOtpVerifyHelper.verifyAndUpdateOtp("Otp", "42", user);
    }

    /**
     * Method under test: {@link TOtpVerifyHelper#verifyAndUpdateOtp(String, String, TOtpUserMasterDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testVerifyAndUpdateOtp2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.domain.totp.usecase.TOtpVerifyHelper.maxFailedAttempts
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpUserMasterSPI.updateLoginSuccess(String, java.time.LocalDateTime)" because "this.tOtpUserMasterSPI" is null
        //       at com.github.godwinpinto.authable.domain.totp.usecase.TOtpVerifyHelper.processSuccessAttempt(TOtpVerifyHelper.java:73)
        //       at com.github.godwinpinto.authable.domain.totp.usecase.TOtpVerifyHelper.verifyAndUpdateOtp(TOtpVerifyHelper.java:68)
        //   See https://diff.blue/R013 to resolve this issue.

        TOtpCryptoSPI tOtpCryptoSPI = mock(TOtpCryptoSPI.class);
        when(tOtpCryptoSPI.verify(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(true);
        TOtpVerifyHelper tOtpVerifyHelper = new TOtpVerifyHelper(null, tOtpCryptoSPI);
        TOtpUserMasterDto user = mock(TOtpUserMasterDto.class);
        when(user.getUserSecret()).thenReturn("User Secret");
        tOtpVerifyHelper.verifyAndUpdateOtp("Otp", "42", user);
    }

    /**
     * Method under test: {@link TOtpVerifyHelper#verifyAndUpdateOtp(String, String, TOtpUserMasterDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testVerifyAndUpdateOtp3() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.domain.totp.usecase.TOtpVerifyHelper.maxFailedAttempts
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.flatMap(java.util.function.Function)" because the return value of "com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpUserMasterSPI.updateLoginSuccess(String, java.time.LocalDateTime)" is null
        //       at com.github.godwinpinto.authable.domain.totp.usecase.TOtpVerifyHelper.processSuccessAttempt(TOtpVerifyHelper.java:75)
        //       at com.github.godwinpinto.authable.domain.totp.usecase.TOtpVerifyHelper.verifyAndUpdateOtp(TOtpVerifyHelper.java:68)
        //   See https://diff.blue/R013 to resolve this issue.

        TOtpUserMasterSPI tOtpUserMasterSPI = mock(TOtpUserMasterSPI.class);
        when(tOtpUserMasterSPI.updateLoginSuccess(Mockito.<String>any(), Mockito.<LocalDateTime>any())).thenReturn(null);
        TOtpCryptoSPI tOtpCryptoSPI = mock(TOtpCryptoSPI.class);
        when(tOtpCryptoSPI.verify(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(true);
        TOtpVerifyHelper tOtpVerifyHelper = new TOtpVerifyHelper(tOtpUserMasterSPI, tOtpCryptoSPI);
        TOtpUserMasterDto user = mock(TOtpUserMasterDto.class);
        when(user.getNoOfAttempts()).thenReturn((short) 1);
        doNothing().when(user)
                .setNoOfAttempts(anyShort());
        when(user.getUserSecret()).thenReturn("User Secret");
        tOtpVerifyHelper.verifyAndUpdateOtp("Otp", "42", user);
    }

    /**
     * Method under test: {@link TOtpVerifyHelper#verifyAndUpdateOtp(String, String, TOtpUserMasterDto)}
     */
    @Test
    void testVerifyAndUpdateOtp4() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.domain.totp.usecase.TOtpVerifyHelper.maxFailedAttempts
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        Mono<Long> mono = mock(Mono.class);
        when(mono.flatMap(Mockito.<Function<Long, Mono<Object>>>any())).thenReturn(null);
        TOtpUserMasterSPI tOtpUserMasterSPI = mock(TOtpUserMasterSPI.class);
        when(tOtpUserMasterSPI.updateLoginSuccess(Mockito.<String>any(), Mockito.<LocalDateTime>any())).thenReturn(mono);
        TOtpCryptoSPI tOtpCryptoSPI = mock(TOtpCryptoSPI.class);
        when(tOtpCryptoSPI.verify(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(true);
        TOtpVerifyHelper tOtpVerifyHelper = new TOtpVerifyHelper(tOtpUserMasterSPI, tOtpCryptoSPI);
        TOtpUserMasterDto user = mock(TOtpUserMasterDto.class);
        when(user.getNoOfAttempts()).thenReturn((short) 1);
        doNothing().when(user)
                .setNoOfAttempts(anyShort());
        when(user.getUserSecret()).thenReturn("User Secret");
        assertNull(tOtpVerifyHelper.verifyAndUpdateOtp("Otp", "42", user));
        verify(tOtpUserMasterSPI).updateLoginSuccess(Mockito.<String>any(), Mockito.<LocalDateTime>any());
        verify(mono).flatMap(Mockito.<Function<Long, Mono<Object>>>any());
        verify(tOtpCryptoSPI).verify(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());
        verify(user).getUserSecret();
    }

    /**
     * Method under test: {@link TOtpVerifyHelper#verifyAndUpdateOtp(String, String, TOtpUserMasterDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testVerifyAndUpdateOtp5() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.domain.totp.usecase.TOtpVerifyHelper.maxFailedAttempts
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.flatMap(java.util.function.Function)" because the return value of "com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpUserMasterSPI.updateInvalidAttempt(String, short, java.time.LocalDateTime)" is null
        //       at com.github.godwinpinto.authable.domain.totp.usecase.TOtpVerifyHelper.processInvalidAttempt(TOtpVerifyHelper.java:95)
        //       at com.github.godwinpinto.authable.domain.totp.usecase.TOtpVerifyHelper.verifyAndUpdateOtp(TOtpVerifyHelper.java:66)
        //   See https://diff.blue/R013 to resolve this issue.

        TOtpUserMasterSPI tOtpUserMasterSPI = mock(TOtpUserMasterSPI.class);
        when(tOtpUserMasterSPI.updateInvalidAttempt(Mockito.<String>any(), anyShort(), Mockito.<LocalDateTime>any()))
                .thenReturn(null);
        when(tOtpUserMasterSPI.updateLoginSuccess(Mockito.<String>any(), Mockito.<LocalDateTime>any()))
                .thenReturn(mock(Mono.class));
        TOtpCryptoSPI tOtpCryptoSPI = mock(TOtpCryptoSPI.class);
        when(tOtpCryptoSPI.verify(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(false);
        TOtpVerifyHelper tOtpVerifyHelper = new TOtpVerifyHelper(tOtpUserMasterSPI, tOtpCryptoSPI);
        TOtpUserMasterDto user = mock(TOtpUserMasterDto.class);
        when(user.getNoOfAttempts()).thenReturn((short) 1);
        doNothing().when(user)
                .setNoOfAttempts(anyShort());
        when(user.getUserSecret()).thenReturn("User Secret");
        tOtpVerifyHelper.verifyAndUpdateOtp("Otp", "42", user);
    }

    /**
     * Method under test: {@link TOtpVerifyHelper#verifyAndUpdateOtp(String, String, TOtpUserMasterDto)}
     */
    @Test
    void testVerifyAndUpdateOtp6() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.domain.totp.usecase.TOtpVerifyHelper.maxFailedAttempts
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        Mono<Long> mono = mock(Mono.class);
        when(mono.flatMap(Mockito.<Function<Long, Mono<Object>>>any())).thenReturn(null);
        TOtpUserMasterSPI tOtpUserMasterSPI = mock(TOtpUserMasterSPI.class);
        when(tOtpUserMasterSPI.updateInvalidAttempt(Mockito.<String>any(), anyShort(), Mockito.<LocalDateTime>any()))
                .thenReturn(mono);
        when(tOtpUserMasterSPI.updateLoginSuccess(Mockito.<String>any(), Mockito.<LocalDateTime>any()))
                .thenReturn(mock(Mono.class));
        TOtpCryptoSPI tOtpCryptoSPI = mock(TOtpCryptoSPI.class);
        when(tOtpCryptoSPI.verify(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(false);
        TOtpVerifyHelper tOtpVerifyHelper = new TOtpVerifyHelper(tOtpUserMasterSPI, tOtpCryptoSPI);
        TOtpUserMasterDto user = mock(TOtpUserMasterDto.class);
        when(user.getNoOfAttempts()).thenReturn((short) 1);
        doNothing().when(user)
                .setNoOfAttempts(anyShort());
        when(user.getUserSecret()).thenReturn("User Secret");
        assertNull(tOtpVerifyHelper.verifyAndUpdateOtp("Otp", "42", user));
        verify(tOtpUserMasterSPI).updateInvalidAttempt(Mockito.<String>any(), anyShort(), Mockito.<LocalDateTime>any());
        verify(mono).flatMap(Mockito.<Function<Long, Mono<Object>>>any());
        verify(tOtpCryptoSPI).verify(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());
        verify(user).getUserSecret();
        verify(user, atLeast(1)).getNoOfAttempts();
        verify(user).setNoOfAttempts(anyShort());
    }
}

