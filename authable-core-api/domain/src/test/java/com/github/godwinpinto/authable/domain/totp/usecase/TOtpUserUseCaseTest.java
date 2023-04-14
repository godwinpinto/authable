package com.github.godwinpinto.authable.domain.totp.usecase;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.github.godwinpinto.authable.domain.totp.dto.TOtpUserMasterDto;
import com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpUserMasterSPI;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;

@ContextConfiguration(classes = {TOtpUserUseCase.class})
@ExtendWith(SpringExtension.class)
class TOtpUserUseCaseTest {
    @MockBean
    private TOtpCreateSecretHelper tOtpCreateSecretHelper;

    @MockBean
    private TOtpGenerateQrHelper tOtpGenerateQrHelper;

    @MockBean
    private TOtpGetUserStatusHelper tOtpGetUserStatusHelper;

    @MockBean
    private TOtpUnBlockUserHelper tOtpUnBlockUserHelper;

    @MockBean
    private TOtpUnSubscribeUserHelper tOtpUnSubscribeUserHelper;

    @MockBean
    private TOtpUserMasterSPI tOtpUserMasterSPI;

    @Autowired
    private TOtpUserUseCase tOtpUserUseCase;

    @MockBean
    private TOtpVerifyHelper tOtpVerifyHelper;

    /**
     * Method under test: {@link TOtpUserUseCase#getUserStatus(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetUserStatus() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.flatMap(java.util.function.Function)" because the return value of "com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpUserMasterSPI.findById(String)" is null
        //       at com.github.godwinpinto.authable.domain.totp.usecase.TOtpUserUseCase.getUserStatus(TOtpUserUseCase.java:51)
        //   See https://diff.blue/R013 to resolve this issue.

        when(tOtpUserMasterSPI.findById(Mockito.<String>any())).thenReturn(null);
        tOtpUserUseCase.getUserStatus("42", "42");
    }

    /**
     * Method under test: {@link TOtpUserUseCase#getUserStatus(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetUserStatus2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.switchIfEmpty(reactor.core.publisher.Mono)" because the return value of "reactor.core.publisher.Mono.flatMap(java.util.function.Function)" is null
        //       at com.github.godwinpinto.authable.domain.totp.usecase.TOtpUserUseCase.getUserStatus(TOtpUserUseCase.java:52)
        //   See https://diff.blue/R013 to resolve this issue.

        when(tOtpUserMasterSPI.findById(Mockito.<String>any())).thenReturn(mock(Mono.class));
        tOtpUserUseCase.getUserStatus("42", "42");
    }

    /**
     * Method under test: {@link TOtpUserUseCase#unBlockUser(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUnBlockUser() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.flatMap(java.util.function.Function)" because the return value of "com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpUserMasterSPI.findById(String)" is null
        //       at com.github.godwinpinto.authable.domain.totp.usecase.TOtpUserUseCase.unBlockUser(TOtpUserUseCase.java:59)
        //   See https://diff.blue/R013 to resolve this issue.

        when(tOtpUserMasterSPI.findById(Mockito.<String>any())).thenReturn(null);
        tOtpUserUseCase.unBlockUser("42", "42");
    }

    /**
     * Method under test: {@link TOtpUserUseCase#unBlockUser(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUnBlockUser2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.switchIfEmpty(reactor.core.publisher.Mono)" because the return value of "reactor.core.publisher.Mono.flatMap(java.util.function.Function)" is null
        //       at com.github.godwinpinto.authable.domain.totp.usecase.TOtpUserUseCase.unBlockUser(TOtpUserUseCase.java:64)
        //   See https://diff.blue/R013 to resolve this issue.

        when(tOtpUserMasterSPI.findById(Mockito.<String>any())).thenReturn(mock(Mono.class));
        when(tOtpUnBlockUserHelper.formatNoSubscriptionMessage()).thenReturn(null);
        tOtpUserUseCase.unBlockUser("42", "42");
    }

    /**
     * Method under test: {@link TOtpUserUseCase#createTOtpSecret(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateTOtpSecret() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.flatMap(java.util.function.Function)" because the return value of "com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpUserMasterSPI.findById(String)" is null
        //       at com.github.godwinpinto.authable.domain.totp.usecase.TOtpUserUseCase.createTOtpSecret(TOtpUserUseCase.java:72)
        //   See https://diff.blue/R013 to resolve this issue.

        when(tOtpUserMasterSPI.findById(Mockito.<String>any())).thenReturn(null);
        tOtpUserUseCase.createTOtpSecret("42", "42");
    }

    /**
     * Method under test: {@link TOtpUserUseCase#createTOtpSecret(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateTOtpSecret2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.flatMap(java.util.function.Function)" because the return value of "reactor.core.publisher.Mono.flatMap(java.util.function.Function)" is null
        //       at com.github.godwinpinto.authable.domain.totp.usecase.TOtpUserUseCase.createTOtpSecret(TOtpUserUseCase.java:73)
        //   See https://diff.blue/R013 to resolve this issue.

        when(tOtpUserMasterSPI.findById(Mockito.<String>any())).thenReturn(mock(Mono.class));
        tOtpUserUseCase.createTOtpSecret("42", "42");
    }

    /**
     * Method under test: {@link TOtpUserUseCase#generateQr(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGenerateQr() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.flatMap(java.util.function.Function)" because the return value of "com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpUserMasterSPI.findById(String)" is null
        //       at com.github.godwinpinto.authable.domain.totp.usecase.TOtpUserUseCase.generateQr(TOtpUserUseCase.java:83)
        //   See https://diff.blue/R013 to resolve this issue.

        when(tOtpUserMasterSPI.findById(Mockito.<String>any())).thenReturn(null);
        tOtpUserUseCase.generateQr("42", "42");
    }

    /**
     * Method under test: {@link TOtpUserUseCase#generateQr(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGenerateQr2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.flatMap(java.util.function.Function)" because the return value of "reactor.core.publisher.Mono.flatMap(java.util.function.Function)" is null
        //       at com.github.godwinpinto.authable.domain.totp.usecase.TOtpUserUseCase.generateQr(TOtpUserUseCase.java:84)
        //   See https://diff.blue/R013 to resolve this issue.

        when(tOtpUserMasterSPI.findById(Mockito.<String>any())).thenReturn(mock(Mono.class));
        tOtpUserUseCase.generateQr("42", "42");
    }

    /**
     * Method under test: {@link TOtpUserUseCase#unSubscribe(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUnSubscribe() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.flatMap(java.util.function.Function)" because the return value of "com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpUserMasterSPI.findById(String)" is null
        //       at com.github.godwinpinto.authable.domain.totp.usecase.TOtpUserUseCase.unSubscribe(TOtpUserUseCase.java:93)
        //   See https://diff.blue/R013 to resolve this issue.

        when(tOtpUserMasterSPI.findById(Mockito.<String>any())).thenReturn(null);
        tOtpUserUseCase.unSubscribe("42", "42");
    }

    /**
     * Method under test: {@link TOtpUserUseCase#unSubscribe(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUnSubscribe2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.flatMap(java.util.function.Function)" because the return value of "reactor.core.publisher.Mono.flatMap(java.util.function.Function)" is null
        //       at com.github.godwinpinto.authable.domain.totp.usecase.TOtpUserUseCase.unSubscribe(TOtpUserUseCase.java:94)
        //   See https://diff.blue/R013 to resolve this issue.

        when(tOtpUserMasterSPI.findById(Mockito.<String>any())).thenReturn(mock(Mono.class));
        tOtpUserUseCase.unSubscribe("42", "42");
    }

    /**
     * Method under test: {@link TOtpUserUseCase#verify(String, String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testVerify() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.flatMap(java.util.function.Function)" because the return value of "com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpUserMasterSPI.findById(String)" is null
        //       at com.github.godwinpinto.authable.domain.totp.usecase.TOtpUserUseCase.verify(TOtpUserUseCase.java:104)
        //   See https://diff.blue/R013 to resolve this issue.

        when(tOtpUserMasterSPI.findById(Mockito.<String>any())).thenReturn(null);
        tOtpUserUseCase.verify("42", "42", "Otp");
    }

    /**
     * Method under test: {@link TOtpUserUseCase#verify(String, String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testVerify2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.flatMap(java.util.function.Function)" because the return value of "reactor.core.publisher.Mono.flatMap(java.util.function.Function)" is null
        //       at com.github.godwinpinto.authable.domain.totp.usecase.TOtpUserUseCase.verify(TOtpUserUseCase.java:105)
        //   See https://diff.blue/R013 to resolve this issue.

        when(tOtpUserMasterSPI.findById(Mockito.<String>any())).thenReturn(mock(Mono.class));
        tOtpUserUseCase.verify("42", "42", "Otp");
    }
}

