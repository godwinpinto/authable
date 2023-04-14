package com.github.godwinpinto.authable.domain.totp.usecase;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.anyShort;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.github.godwinpinto.authable.commons.auth.config.FetchPrincipalComponent;
import com.github.godwinpinto.authable.domain.auth.dto.UserDto;
import com.github.godwinpinto.authable.domain.totp.dto.TOtpUserMasterDto;
import com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpCryptoSPI;
import com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpUserMasterSPI;

import java.time.LocalDateTime;
import java.util.function.Function;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;

@ContextConfiguration(classes = {TOtpCreateSecretHelper.class})
@ExtendWith(SpringExtension.class)
class TOtpCreateSecretHelperTest {
    @MockBean
    private FetchPrincipalComponent fetchPrincipalComponent;

    @Autowired
    private TOtpCreateSecretHelper tOtpCreateSecretHelper;

    @MockBean
    private TOtpCryptoSPI tOtpCryptoSPI;

    @MockBean
    private TOtpUserMasterSPI tOtpUserMasterSPI;

    /**
     * Method under test: {@link TOtpCreateSecretHelper#isAllowedToReset(TOtpUserMasterDto)}
     */
    @Test
    void testIsAllowedToReset() {
        TOtpUserMasterDto user = mock(TOtpUserMasterDto.class);
        when(user.getStatus()).thenReturn("Status");
        tOtpCreateSecretHelper.isAllowedToReset(user);
        verify(user, atLeast(1)).getStatus();
    }

    /**
     * Method under test: {@link TOtpCreateSecretHelper#isAllowedToReset(TOtpUserMasterDto)}
     */
    @Test
    void testIsAllowedToReset2() {
        TOtpUserMasterDto user = mock(TOtpUserMasterDto.class);
        when(user.getStatus()).thenReturn("D");
        tOtpCreateSecretHelper.isAllowedToReset(user);
        verify(user).getStatus();
    }

    /**
     * Method under test: {@link TOtpCreateSecretHelper#isAllowedToReset(TOtpUserMasterDto)}
     */
    @Test
    void testIsAllowedToReset3() {
        TOtpUserMasterDto user = mock(TOtpUserMasterDto.class);
        when(user.getStatus()).thenReturn("A");
        tOtpCreateSecretHelper.isAllowedToReset(user);
        verify(user, atLeast(1)).getStatus();
    }

    /**
     * Method under test: {@link TOtpCreateSecretHelper#isAllowedToReset(TOtpUserMasterDto)}
     */
    @Test
    void testIsAllowedToReset4() {
        TOtpUserMasterDto user = mock(TOtpUserMasterDto.class);
        when(user.getStatus()).thenReturn("N");
        tOtpCreateSecretHelper.isAllowedToReset(user);
        verify(user, atLeast(1)).getStatus();
    }

    /**
     * Method under test: {@link TOtpCreateSecretHelper#updateDbToReset(String, TOtpUserMasterDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateDbToReset() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.flatMap(java.util.function.Function)" because the return value of "com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpUserMasterSPI.updateEntity(com.github.godwinpinto.authable.domain.totp.dto.TOtpUserMasterDto)" is null
        //       at com.github.godwinpinto.authable.domain.totp.usecase.TOtpCreateSecretHelper.updateDbToReset(TOtpCreateSecretHelper.java:61)
        //   See https://diff.blue/R013 to resolve this issue.

        when(tOtpUserMasterSPI.updateEntity(Mockito.<TOtpUserMasterDto>any())).thenReturn(null);
        when(tOtpCryptoSPI.generateSecretKey(Mockito.<String>any()))
                .thenReturn("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
        TOtpUserMasterDto user = mock(TOtpUserMasterDto.class);
        doNothing().when(user)
                .setCreationDateTime(Mockito.<LocalDateTime>any());
        doNothing().when(user)
                .setCreationId(Mockito.<String>any());
        doNothing().when(user)
                .setInvalidAttemptDateTime(Mockito.<LocalDateTime>any());
        doNothing().when(user)
                .setLastLoginDateTime(Mockito.<LocalDateTime>any());
        doNothing().when(user)
                .setLockedDateTime(Mockito.<LocalDateTime>any());
        doNothing().when(user)
                .setModificationDateTime(Mockito.<LocalDateTime>any());
        doNothing().when(user)
                .setModificationId(Mockito.<String>any());
        doNothing().when(user)
                .setNoOfAttempts(anyShort());
        doNothing().when(user)
                .setStatus(Mockito.<String>any());
        doNothing().when(user)
                .setUserSecret(Mockito.<String>any());
        tOtpCreateSecretHelper.updateDbToReset("42", user);
    }

    /**
     * Method under test: {@link TOtpCreateSecretHelper#updateDbToReset(String, TOtpUserMasterDto)}
     */
    @Test
    void testUpdateDbToReset2() {
        Mono<Long> mono = mock(Mono.class);
        when(mono.flatMap(Mockito.<Function<Long, Mono<Object>>>any())).thenReturn(null);
        when(tOtpUserMasterSPI.updateEntity(Mockito.<TOtpUserMasterDto>any())).thenReturn(mono);
        when(tOtpCryptoSPI.generateSecretKey(Mockito.<String>any()))
                .thenReturn("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
        TOtpUserMasterDto user = mock(TOtpUserMasterDto.class);
        doNothing().when(user)
                .setCreationDateTime(Mockito.<LocalDateTime>any());
        doNothing().when(user)
                .setCreationId(Mockito.<String>any());
        doNothing().when(user)
                .setInvalidAttemptDateTime(Mockito.<LocalDateTime>any());
        doNothing().when(user)
                .setLastLoginDateTime(Mockito.<LocalDateTime>any());
        doNothing().when(user)
                .setLockedDateTime(Mockito.<LocalDateTime>any());
        doNothing().when(user)
                .setModificationDateTime(Mockito.<LocalDateTime>any());
        doNothing().when(user)
                .setModificationId(Mockito.<String>any());
        doNothing().when(user)
                .setNoOfAttempts(anyShort());
        doNothing().when(user)
                .setStatus(Mockito.<String>any());
        doNothing().when(user)
                .setUserSecret(Mockito.<String>any());
        assertNull(tOtpCreateSecretHelper.updateDbToReset("42", user));
        verify(tOtpUserMasterSPI).updateEntity(Mockito.<TOtpUserMasterDto>any());
        verify(mono).flatMap(Mockito.<Function<Long, Mono<Object>>>any());
        verify(tOtpCryptoSPI).generateSecretKey(Mockito.<String>any());
        verify(user).setCreationDateTime(Mockito.<LocalDateTime>any());
        verify(user).setCreationId(Mockito.<String>any());
        verify(user).setInvalidAttemptDateTime(Mockito.<LocalDateTime>any());
        verify(user).setLastLoginDateTime(Mockito.<LocalDateTime>any());
        verify(user).setLockedDateTime(Mockito.<LocalDateTime>any());
        verify(user).setModificationDateTime(Mockito.<LocalDateTime>any());
        verify(user).setModificationId(Mockito.<String>any());
        verify(user).setNoOfAttempts(anyShort());
        verify(user).setStatus(Mockito.<String>any());
        verify(user).setUserSecret(Mockito.<String>any());
    }

    /**
     * Method under test: {@link TOtpCreateSecretHelper#createNewRecord(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateNewRecord() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.flatMap(java.util.function.Function)" because the return value of "com.github.godwinpinto.authable.commons.auth.config.FetchPrincipalComponent.getAuthDetails()" is null
        //       at com.github.godwinpinto.authable.domain.totp.usecase.TOtpCreateSecretHelper.createNewRecord(TOtpCreateSecretHelper.java:73)
        //   See https://diff.blue/R013 to resolve this issue.

        when(fetchPrincipalComponent.getAuthDetails()).thenReturn(null);
        tOtpCreateSecretHelper.createNewRecord("42", "42");
    }

    /**
     * Method under test: {@link TOtpCreateSecretHelper#createNewRecord(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateNewRecord2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.flatMap(java.util.function.Function)" because the return value of "reactor.core.publisher.Mono.flatMap(java.util.function.Function)" is null
        //       at com.github.godwinpinto.authable.domain.totp.usecase.TOtpCreateSecretHelper.createNewRecord(TOtpCreateSecretHelper.java:74)
        //   See https://diff.blue/R013 to resolve this issue.

        when(fetchPrincipalComponent.getAuthDetails()).thenReturn(mock(Mono.class));
        tOtpCreateSecretHelper.createNewRecord("42", "42");
    }

    /**
     * Method under test: {@link TOtpCreateSecretHelper#fallbackMethod(Throwable)}
     */
    @Test
    void testFallbackMethod() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        tOtpCreateSecretHelper.fallbackMethod(new Throwable());
    }

    /**
     * Method under test: {@link TOtpCreateSecretHelper#fallbackMethod(Throwable)}
     */
    @Test
    void testFallbackMethod2() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        tOtpCreateSecretHelper.fallbackMethod(new Throwable("Not all who wander are lost"));
    }
}

