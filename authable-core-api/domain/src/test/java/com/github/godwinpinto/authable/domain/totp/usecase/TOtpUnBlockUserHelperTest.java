package com.github.godwinpinto.authable.domain.totp.usecase;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

@ContextConfiguration(classes = {TOtpUnBlockUserHelper.class})
@ExtendWith(SpringExtension.class)
class TOtpUnBlockUserHelperTest {
    @Autowired
    private TOtpUnBlockUserHelper tOtpUnBlockUserHelper;

    @MockBean
    private TOtpUserMasterSPI tOtpUserMasterSPI;

    /**
     * Method under test: {@link TOtpUnBlockUserHelper#isUserDisabledOrActive(TOtpUserMasterDto)}
     */
    @Test
    void testIsUserDisabledOrActive() {
        TOtpUserMasterDto user = mock(TOtpUserMasterDto.class);
        when(user.getStatus()).thenReturn("Status");
        assertFalse(tOtpUnBlockUserHelper.isUserDisabledOrActive(user));
        verify(user).getStatus();
    }

    /**
     * Method under test: {@link TOtpUnBlockUserHelper#isUserDisabledOrActive(TOtpUserMasterDto)}
     */
    @Test
    void testIsUserDisabledOrActive2() {
        TOtpUserMasterDto user = mock(TOtpUserMasterDto.class);
        when(user.getStatus()).thenReturn("N");
        assertTrue(tOtpUnBlockUserHelper.isUserDisabledOrActive(user));
        verify(user).getStatus();
    }

    /**
     * Method under test: {@link TOtpUnBlockUserHelper#changeFlagInDatabase(String, TOtpUserMasterDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeFlagInDatabase() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.flatMap(java.util.function.Function)" because the return value of "com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpUserMasterSPI.removeDisabledStatus(String, java.time.LocalDateTime, String)" is null
        //       at com.github.godwinpinto.authable.domain.totp.usecase.TOtpUnBlockUserHelper.changeFlagInDatabase(TOtpUnBlockUserHelper.java:34)
        //   See https://diff.blue/R013 to resolve this issue.

        when(tOtpUserMasterSPI.removeDisabledStatus(Mockito.<String>any(), Mockito.<LocalDateTime>any(),
                Mockito.<String>any())).thenReturn(null);
        tOtpUnBlockUserHelper.changeFlagInDatabase("42", mock(TOtpUserMasterDto.class));
    }

    /**
     * Method under test: {@link TOtpUnBlockUserHelper#changeFlagInDatabase(String, TOtpUserMasterDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeFlagInDatabase2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.switchIfEmpty(reactor.core.publisher.Mono)" because the return value of "reactor.core.publisher.Mono.flatMap(java.util.function.Function)" is null
        //       at com.github.godwinpinto.authable.domain.totp.usecase.TOtpUnBlockUserHelper.changeFlagInDatabase(TOtpUnBlockUserHelper.java:43)
        //   See https://diff.blue/R013 to resolve this issue.

        when(tOtpUserMasterSPI.removeDisabledStatus(Mockito.<String>any(), Mockito.<LocalDateTime>any(),
                Mockito.<String>any())).thenReturn(mock(Mono.class));
        tOtpUnBlockUserHelper.changeFlagInDatabase("42", mock(TOtpUserMasterDto.class));
    }

    /**
     * Method under test: {@link TOtpUnBlockUserHelper#formatNoSubscriptionMessage()}
     */
    @Test
    void testFormatNoSubscriptionMessage() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        tOtpUnBlockUserHelper.formatNoSubscriptionMessage();
    }

    /**
     * Method under test: {@link TOtpUnBlockUserHelper#fallbackMethod(Throwable)}
     */
    @Test
    void testFallbackMethod() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        tOtpUnBlockUserHelper.fallbackMethod(new Throwable());
    }
}

