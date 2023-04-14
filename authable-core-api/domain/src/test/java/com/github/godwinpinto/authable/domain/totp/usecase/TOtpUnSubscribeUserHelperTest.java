package com.github.godwinpinto.authable.domain.totp.usecase;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.github.godwinpinto.authable.domain.totp.dto.TOtpUserMasterDto;
import com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpUserMasterSPI;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;

@ContextConfiguration(classes = {TOtpUnSubscribeUserHelper.class})
@ExtendWith(SpringExtension.class)
class TOtpUnSubscribeUserHelperTest {
    @Autowired
    private TOtpUnSubscribeUserHelper tOtpUnSubscribeUserHelper;

    @MockBean
    private TOtpUserMasterSPI tOtpUserMasterSPI;

    /**
     * Method under test: {@link TOtpUnSubscribeUserHelper#isUserDisabledOrNonActive(TOtpUserMasterDto)}
     */
    @Test
    void testIsUserDisabledOrNonActive() {
        TOtpUserMasterDto user = mock(TOtpUserMasterDto.class);
        when(user.getStatus()).thenReturn("Status");
        tOtpUnSubscribeUserHelper.isUserDisabledOrNonActive(user);
        verify(user, atLeast(1)).getStatus();
    }

    /**
     * Method under test: {@link TOtpUnSubscribeUserHelper#isUserDisabledOrNonActive(TOtpUserMasterDto)}
     */
    @Test
    void testIsUserDisabledOrNonActive2() {
        TOtpUserMasterDto user = mock(TOtpUserMasterDto.class);
        when(user.getStatus()).thenReturn("N");
        tOtpUnSubscribeUserHelper.isUserDisabledOrNonActive(user);
        verify(user).getStatus();
    }

    /**
     * Method under test: {@link TOtpUnSubscribeUserHelper#isUserDisabledOrNonActive(TOtpUserMasterDto)}
     */
    @Test
    void testIsUserDisabledOrNonActive3() {
        TOtpUserMasterDto user = mock(TOtpUserMasterDto.class);
        when(user.getStatus()).thenReturn("A");
        tOtpUnSubscribeUserHelper.isUserDisabledOrNonActive(user);
        verify(user, atLeast(1)).getStatus();
    }

    /**
     * Method under test: {@link TOtpUnSubscribeUserHelper#isUserDisabledOrNonActive(TOtpUserMasterDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testIsUserDisabledOrNonActive4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.RuntimeException
        //       at com.github.godwinpinto.authable.domain.totp.dto.TOtpUserMasterDto.getStatus(TOtpUserMasterDto.java:28)
        //       at com.github.godwinpinto.authable.domain.totp.usecase.TOtpUnSubscribeUserHelper.isUserDisabledOrNonActive(TOtpUnSubscribeUserHelper.java:23)
        //   See https://diff.blue/R013 to resolve this issue.

        TOtpUserMasterDto user = mock(TOtpUserMasterDto.class);
        when(user.getStatus()).thenThrow(new RuntimeException());
        tOtpUnSubscribeUserHelper.isUserDisabledOrNonActive(user);
    }

    /**
     * Method under test: {@link TOtpUnSubscribeUserHelper#updateDbToUnsubscribe(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateDbToUnsubscribe() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.flatMap(java.util.function.Function)" because the return value of "com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpUserMasterSPI.removeDisabledStatus(String, java.time.LocalDateTime, String)" is null
        //       at com.github.godwinpinto.authable.domain.totp.usecase.TOtpUnSubscribeUserHelper.updateDbToUnsubscribe(TOtpUnSubscribeUserHelper.java:37)
        //   See https://diff.blue/R013 to resolve this issue.

        when(tOtpUserMasterSPI.removeDisabledStatus(Mockito.<String>any(), Mockito.<LocalDateTime>any(),
                Mockito.<String>any())).thenReturn(null);
        tOtpUnSubscribeUserHelper.updateDbToUnsubscribe("42");
    }

    /**
     * Method under test: {@link TOtpUnSubscribeUserHelper#updateDbToUnsubscribe(String)}
     */
    @Test
    void testUpdateDbToUnsubscribe2() {
        when(tOtpUserMasterSPI.removeDisabledStatus(Mockito.<String>any(), Mockito.<LocalDateTime>any(),
                Mockito.<String>any())).thenThrow(new RuntimeException());
        assertThrows(RuntimeException.class, () -> tOtpUnSubscribeUserHelper.updateDbToUnsubscribe("42"));
        verify(tOtpUserMasterSPI).removeDisabledStatus(Mockito.<String>any(), Mockito.<LocalDateTime>any(),
                Mockito.<String>any());
    }

    /**
     * Method under test: {@link TOtpUnSubscribeUserHelper#updateDbToUnsubscribe(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateDbToUnsubscribe3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.switchIfEmpty(reactor.core.publisher.Mono)" because the return value of "reactor.core.publisher.Mono.flatMap(java.util.function.Function)" is null
        //       at com.github.godwinpinto.authable.domain.totp.usecase.TOtpUnSubscribeUserHelper.updateDbToUnsubscribe(TOtpUnSubscribeUserHelper.java:41)
        //   See https://diff.blue/R013 to resolve this issue.

        when(tOtpUserMasterSPI.removeDisabledStatus(Mockito.<String>any(), Mockito.<LocalDateTime>any(),
                Mockito.<String>any())).thenReturn(mock(Mono.class));
        tOtpUnSubscribeUserHelper.updateDbToUnsubscribe("42");
    }

    /**
     * Method under test: {@link TOtpUnSubscribeUserHelper#formatNoRecordFoundMessage()}
     */
    @Test
    void testFormatNoRecordFoundMessage() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        tOtpUnSubscribeUserHelper.formatNoRecordFoundMessage();
    }

    /**
     * Method under test: {@link TOtpUnSubscribeUserHelper#fallbackMethod(Throwable)}
     */
    @Test
    void testFallbackMethod() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        tOtpUnSubscribeUserHelper.fallbackMethod(new Throwable());
    }

    /**
     * Method under test: {@link TOtpUnSubscribeUserHelper#fallbackMethod(Throwable)}
     */
    @Test
    void testFallbackMethod2() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        tOtpUnSubscribeUserHelper.fallbackMethod(new Throwable("Not all who wander are lost"));
    }
}

