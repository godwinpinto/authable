package com.github.godwinpinto.authable.domain.totp.usecase;

import com.github.godwinpinto.authable.commons.exception.NonFatalException;
import com.github.godwinpinto.authable.domain.totp.dto.*;
import com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpUserMasterSPI;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;


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

    @Test
    void getUserStatus_NoUser_Test() {

        TOtpUserStatusDto expected = TOtpUserStatusDto.builder()
                .statusCode("N")
                .statusDescription("No Active Subscription")
                .build();
        doReturn(Mono.empty()).when(this.tOtpUserMasterSPI)
                .findById(any());
        doReturn(Mono.just(expected)).when(this.tOtpGetUserStatusHelper)
                .recordNotFound();
        StepVerifier.create(tOtpUserUseCase.getUserStatus("TEST_SYSTEM", "TEST_USER"))
                .assertNext(actual -> {
                            assertEquals(expected.toString(), actual.toString());
                        }
                )
                .verifyComplete();
    }

    @Test
    void getUserStatus_CheckStatus_Test() {

        TOtpUserMasterDto tOtpUserMasterDto = TOtpUserMasterDto.builder()
                .status("A")
                .build();

        TOtpUserStatusDto expected = TOtpUserStatusDto.builder()
                .statusCode("200")
                .statusDescription("User is Subscribed for TOTP.")
                .build();

        doReturn(Mono.just(tOtpUserMasterDto)).when(this.tOtpUserMasterSPI)
                .findById(any());
        doReturn(Mono.just(expected)).when(this.tOtpGetUserStatusHelper)
                .userStatusFromDatabase(any());

        StepVerifier.create(tOtpUserUseCase.getUserStatus("TEST_SYSTEM", "TEST_USER"))
                .assertNext(actual -> {
                            assertEquals(expected.toString(), actual.toString());
                        }
                )
                .verifyComplete();
    }

    @Test
    void unBlockUser_NoUser_Test() {
        TOtpUnBlockUserDto expected = TOtpUnBlockUserDto.builder()
                .statusCode("200")
                .statusDescription("No active subscription found for user")
                .build();

        doReturn(Mono.empty()).when(this.tOtpUserMasterSPI)
                .findById(any());
        doReturn(Mono.just(expected)).when(this.tOtpUnBlockUserHelper)
                .formatNoSubscriptionMessage();
        StepVerifier.create(tOtpUserUseCase.unBlockUser("TEST_SYSTEM", "TEST_USER"))
                .assertNext(actual -> {
                            assertEquals(expected.toString(), actual.toString());
                        }
                )
                .verifyComplete();
    }

    @Test
    void unBlockUser_UserExists_Test() {
        TOtpUserMasterDto tOtpUserMasterDto = TOtpUserMasterDto.builder()
                .status("A")
                .build();

        TOtpUnBlockUserDto expected = TOtpUnBlockUserDto.builder()
                .statusCode("200")
                .statusDescription("TOTP subscription cancelled for user")
                .build();

        TOtpUnBlockUserDto expectedFail = TOtpUnBlockUserDto.builder()
                .statusCode("200")
                .statusDescription("No active subscription found for user")
                .build();


        doReturn(Mono.just(tOtpUserMasterDto)).when(this.tOtpUserMasterSPI)
                .findById(any());
        doReturn(true).when(this.tOtpUnBlockUserHelper)
                .isUserDisabledOrActive(any(TOtpUserMasterDto.class));

        doReturn(Mono.just(expectedFail)).when(this.tOtpUnBlockUserHelper)
                .formatNoSubscriptionMessage();

        doReturn(Mono.just(expected)).when(this.tOtpUnBlockUserHelper)
                .changeFlagInDatabase(any(), any(TOtpUserMasterDto.class));
        StepVerifier.create(tOtpUserUseCase.unBlockUser("TEST_SYSTEM", "TEST_USER"))
                .assertNext(actual -> {
                            assertEquals(expected.toString(), actual.toString());
                        }
                )
                .verifyComplete();

        doReturn(true).when(this.tOtpUnBlockUserHelper)
                .isUserDisabledOrActive(any(TOtpUserMasterDto.class));

        doReturn(false).when(this.tOtpUnBlockUserHelper)
                .isUserDisabledOrActive(any(TOtpUserMasterDto.class));

        StepVerifier.create(tOtpUserUseCase.unBlockUser("TEST_SYSTEM", "TEST_USER"))
                .assertNext(actual -> {
                            assertEquals(expectedFail.toString(), actual.toString());
                        }
                )
                .verifyComplete();

        doReturn(true).when(this.tOtpUnBlockUserHelper)
                .isUserDisabledOrActive(any(TOtpUserMasterDto.class));

        doReturn(Mono.error(new NonFatalException("300", "Failure in updating"))).when(this.tOtpUnBlockUserHelper)
                .changeFlagInDatabase(any(), any(TOtpUserMasterDto.class));

        TOtpUnBlockUserDto expectedException = TOtpUnBlockUserDto.builder()
                .statusCode("300")
                .statusDescription("Failure in updating")
                .build();

        doReturn(Mono.just(expectedException)).when(this.tOtpUnBlockUserHelper)
                .fallbackMethod(any());


        StepVerifier.create(tOtpUserUseCase.unBlockUser("TEST_SYSTEM", "TEST_USER"))
                .assertNext(actual -> {
                            assertEquals(expectedException.toString(), actual.toString());
                        }
                )
                .verifyComplete();

    }

    @Test
    void unSubscribe_NoUser_Test() {
        TOtpUnSubscribeUserDto expected = TOtpUnSubscribeUserDto.builder()
                .statusCode("200")
                .statusDescription("No active subscription found for user")
                .build();

        doReturn(Mono.empty()).when(this.tOtpUserMasterSPI)
                .findById(any());
        doReturn(Mono.just(expected)).when(this.tOtpUnSubscribeUserHelper)
                .formatNoRecordFoundMessage();
        StepVerifier.create(tOtpUserUseCase.unSubscribe("TEST_SYSTEM", "TEST_USER"))
                .assertNext(actual -> {
                            assertEquals(expected.toString(), actual.toString());
                        }
                )
                .verifyComplete();
    }

    @Test
    void unSubscribe_Flow_Test() {

        TOtpUserMasterDto tOtpUserMasterDto = TOtpUserMasterDto.builder()
                .status("N")
                .build();


        TOtpUnSubscribeUserDto expected = TOtpUnSubscribeUserDto.builder()
                .statusCode("200")
                .statusDescription("You have already Unsubscribed from TOTP")
                .build();

        TOtpUnSubscribeUserDto exception1 = TOtpUnSubscribeUserDto.builder()
                .statusCode("200")
                .statusDescription("You have already Unsubscribed from TOTP")
                .build();

        TOtpUnSubscribeUserDto exception2 = TOtpUnSubscribeUserDto.builder()
                .statusCode("300")
                .statusDescription("Your TOTP is blocked. Please contact administrator to unblock.")
                .build();


        doReturn(Mono.just(tOtpUserMasterDto)).when(this.tOtpUserMasterSPI)
                .findById(any());
        doReturn(Mono.just(expected)).when(this.tOtpUnSubscribeUserHelper)
                .formatNoRecordFoundMessage();
        doReturn(Mono.error(new NonFatalException("200", "You have already Unsubscribed from TOTP"))).when(this.tOtpUnSubscribeUserHelper)
                .isUserDisabledOrNonActive(any(TOtpUserMasterDto.class));
        doReturn(Mono.just(exception1)).when(this.tOtpUnSubscribeUserHelper)
                .fallbackMethod(any());

        StepVerifier.create(tOtpUserUseCase.unSubscribe("TEST_SYSTEM", "TEST_USER"))
                .assertNext(actual -> {
                            assertEquals(expected.toString(), actual.toString());
                        }
                )
                .verifyComplete();

        tOtpUserMasterDto.setStatus("D");
        doReturn(Mono.just(tOtpUserMasterDto)).when(this.tOtpUserMasterSPI)
                .findById(any());
        doReturn(Mono.just(exception2)).when(this.tOtpUnSubscribeUserHelper)
                .fallbackMethod(any());
        doReturn(Mono.error(new NonFatalException("300", "Your TOTP is blocked. Please contact administrator to unblock."))).when(this.tOtpUnSubscribeUserHelper)
                .isUserDisabledOrNonActive(any(TOtpUserMasterDto.class));

        StepVerifier.create(tOtpUserUseCase.unSubscribe("TEST_SYSTEM", "TEST_USER"))
                .assertNext(actual -> {
                            assertEquals(exception2.toString(), actual.toString());
                        }
                )
                .verifyComplete();


        TOtpUnSubscribeUserDto success = TOtpUnSubscribeUserDto.builder()
                .statusCode("200")
                .statusDescription("TOTP subscription cancelled for user")
                .build();
        tOtpUserMasterDto.setStatus("A");
        doReturn(Mono.just(tOtpUserMasterDto)).when(this.tOtpUserMasterSPI)
                .findById(any());
        doReturn(Mono.just(tOtpUserMasterDto)).when(this.tOtpUnSubscribeUserHelper)
                .isUserDisabledOrNonActive(any(TOtpUserMasterDto.class));
        doReturn(Mono.just(success)).when(this.tOtpUnSubscribeUserHelper)
                .updateDbToUnsubscribe(any());
        StepVerifier.create(tOtpUserUseCase.unSubscribe("TEST_SYSTEM", "TEST_USER"))
                .assertNext(actual -> {
                            assertEquals(success.toString(), actual.toString());
                        }
                )
                .verifyComplete();
    }

    @Test
    void verify_NoUser_Test() {
        TOtpVerifyDto expected = TOtpVerifyDto.builder()
                .statusCode("200")
                .statusDescription("No active subscription found for user")
                .build();

        doReturn(Mono.empty()).when(this.tOtpUserMasterSPI)
                .findById(any());
        doReturn(Mono.just(expected)).when(this.tOtpVerifyHelper)
                .formatNoSubscriptionMessage();
        StepVerifier.create(tOtpUserUseCase.verify("TEST_SYSTEM", "TEST_USER", "123456"))
                .assertNext(actual -> {
                            assertEquals(expected.toString(), actual.toString());
                        }
                )
                .verifyComplete();
    }

    @Test
    void verify_Flow_Test() {

        TOtpUserMasterDto tOtpUserMasterDto = TOtpUserMasterDto.builder()
                .status("N")
                .build();


        TOtpVerifyDto expected = TOtpVerifyDto.builder()
                .statusCode("200")
                .statusDescription("You have already Unsubscribed from TOTP")
                .build();

        TOtpVerifyDto exception1 = TOtpVerifyDto.builder()
                .statusCode("300")
                .statusDescription("Access is inactive or disabled for the user")
                .build();

        TOtpVerifyDto exception2 = TOtpVerifyDto.builder()
                .statusCode("300")
                .statusDescription("Your TOTP is blocked. Please contact administrator to unblock.")
                .build();


        doReturn(Mono.just(tOtpUserMasterDto)).when(this.tOtpUserMasterSPI)
                .findById(any());
        doReturn(Mono.just(expected)).when(this.tOtpVerifyHelper)
                .formatNoSubscriptionMessage();
        doReturn(Mono.error(new NonFatalException("300", "Access is inactive or disabled for the user"))).when(this.tOtpVerifyHelper)
                .isUserNotActive(any(TOtpUserMasterDto.class));
        doReturn(Mono.just(exception1)).when(this.tOtpVerifyHelper)
                .fallbackMethod(any());

        StepVerifier.create(tOtpUserUseCase.verify("TEST_SYSTEM", "TEST_USER", "123456"))
                .assertNext(actual -> {
                            assertEquals(exception1.toString(), actual.toString());
                        }
                )
                .verifyComplete();

        tOtpUserMasterDto.setStatus("D");
        doReturn(Mono.just(tOtpUserMasterDto)).when(this.tOtpUserMasterSPI)
                .findById(any());
        doReturn(Mono.just(exception1)).when(this.tOtpVerifyHelper)
                .fallbackMethod(any());
        doReturn(Mono.error(new NonFatalException("300", "Access is inactive or disabled for the user"))).when(this.tOtpVerifyHelper)
                .isUserNotActive(any(TOtpUserMasterDto.class));

        StepVerifier.create(tOtpUserUseCase.verify("TEST_SYSTEM", "TEST_USER", "123456"))
                .assertNext(actual -> {
                            assertEquals(exception1.toString(), actual.toString());
                        }
                )
                .verifyComplete();


        TOtpVerifyDto success = TOtpVerifyDto.builder()
                .statusCode("200")
                .statusDescription("Verification successful")
                .build();
        tOtpUserMasterDto.setStatus("A");
        doReturn(Mono.just(tOtpUserMasterDto)).when(this.tOtpUserMasterSPI)
                .findById(any());
        doReturn(Mono.just(tOtpUserMasterDto)).when(this.tOtpVerifyHelper)
                .isUserNotActive(any(TOtpUserMasterDto.class));
        doReturn(Mono.just(success)).when(this.tOtpVerifyHelper)
                .verifyAndUpdateOtp(any(), any(), any());
        StepVerifier.create(tOtpUserUseCase.verify("TEST_SYSTEM", "TEST_USER", "123456"))
                .assertNext(actual -> {
                            assertEquals(success.toString(), actual.toString());
                        }
                )
                .verifyComplete();
    }


    @Test
    void createTOtpSecret_NoUser_Test() {
        TOtpCreateNewDto expected = TOtpCreateNewDto.builder()
                .statusCode("200")
                .statusDescription("TOTP generated successfully.")
                .build();

        doReturn(Mono.empty()).when(this.tOtpUserMasterSPI)
                .findById(any());
        doReturn(Mono.just(expected)).when(this.tOtpCreateSecretHelper)
                .createNewRecord(any(), any());

        StepVerifier.create(tOtpUserUseCase.createTOtpSecret("TEST_SYSTEM", "TEST_USER"))
                .assertNext(actual -> {
                            assertEquals(expected.toString(), actual.toString());
                        }
                )
                .verifyComplete();
    }

    @Test
    void createTOtpSecret_Flow_Test() {

        TOtpUserMasterDto tOtpUserMasterDto = TOtpUserMasterDto.builder()
                .status("D")
                .build();


        TOtpCreateNewDto expected = TOtpCreateNewDto.builder()
                .statusCode("200")
                .statusDescription("Your TOTP is disabled. Contact administrator")
                .build();

        TOtpCreateNewDto exception1 = TOtpCreateNewDto.builder()
                .statusCode("300")
                .statusDescription("Your TOTP is disabled. Contact administrator")
                .build();

        TOtpCreateNewDto exception2 = TOtpCreateNewDto.builder()
                .statusCode("300")
                .statusDescription("Your TOTP is blocked. Please contact administrator to unblock.")
                .build();


        doReturn(Mono.just(tOtpUserMasterDto)).when(this.tOtpUserMasterSPI)
                .findById(any());
        doReturn(Mono.error(new NonFatalException("300", "Your TOTP is disabled. Contact administrator"))).when(this.tOtpCreateSecretHelper)
                .isAllowedToReset(any(TOtpUserMasterDto.class));
        doReturn(Mono.just(exception1)).when(this.tOtpCreateSecretHelper)
                .fallbackMethod(any());

        StepVerifier.create(tOtpUserUseCase.createTOtpSecret("TEST_SYSTEM", "TEST_USER"))
                .assertNext(actual -> {
                            assertEquals(exception1.toString(), actual.toString());
                        }
                )
                .verifyComplete();

        TOtpCreateNewDto success = TOtpCreateNewDto.builder()
                .statusCode("200")
                .statusDescription("TOTP generated successfully.")
                .build();
        tOtpUserMasterDto.setStatus("A");
        doReturn(Mono.just(tOtpUserMasterDto)).when(this.tOtpUserMasterSPI)
                .findById(any());
        doReturn(Mono.just(tOtpUserMasterDto)).when(this.tOtpCreateSecretHelper)
                .isAllowedToReset(any(TOtpUserMasterDto.class));
        doReturn(Mono.just(success)).when(this.tOtpCreateSecretHelper)
                .updateDbToReset(any(), any());
        StepVerifier.create(tOtpUserUseCase.createTOtpSecret("TEST_SYSTEM", "TEST_USER"))
                .assertNext(actual -> {
                            assertEquals(success.toString(), actual.toString());
                        }
                )
                .verifyComplete();
    }


    @Test
    void generateQr_NoUser_Test() {
        TOtpGenerateQrDto expected = TOtpGenerateQrDto.builder()
                .statusCode("200")
                .statusDescription("No active subscription found for user")
                .build();

        doReturn(Mono.empty()).when(this.tOtpUserMasterSPI)
                .findById(any());
        doReturn(Mono.just(expected)).when(this.tOtpGenerateQrHelper)
                .formatNoSubscriptionMessage();
        StepVerifier.create(tOtpUserUseCase.generateQr("TEST_SYSTEM", "TEST_USER"))
                .assertNext(actual -> {
                            assertEquals(expected.toString(), actual.toString());
                        }
                )
                .verifyComplete();
    }

    @Test
    void generateQr_Flow_Test() {

        TOtpUserMasterDto tOtpUserMasterDto = TOtpUserMasterDto.builder()
                .status("N")
                .build();


        TOtpGenerateQrDto expected = TOtpGenerateQrDto.builder()
                .statusCode("200")
                .statusDescription("No active subscription found for user")
                .build();

        TOtpGenerateQrDto exception1 = TOtpGenerateQrDto.builder()
                .statusCode("300")
                .statusDescription("Your TOTP is disabled. Contact administrator")
                .build();

        TOtpGenerateQrDto exception2 = TOtpGenerateQrDto.builder()
                .statusCode("300")
                .statusDescription("Your TOTP is blocked. Please contact administrator to unblock.")
                .build();


        doReturn(Mono.just(tOtpUserMasterDto)).when(this.tOtpUserMasterSPI)
                .findById(any());
        doReturn(Mono.just(expected)).when(this.tOtpGenerateQrHelper)
                .formatNoSubscriptionMessage();
        doReturn(Mono.error(new NonFatalException("300", "Your TOTP is disabled. Contact administrator"))).when(this.tOtpGenerateQrHelper)
                .canGenerateQr(any(TOtpUserMasterDto.class));
        doReturn(Mono.just(exception1)).when(this.tOtpGenerateQrHelper)
                .fallbackMethod(any());

        StepVerifier.create(tOtpUserUseCase.generateQr("TEST_SYSTEM", "TEST_USER"))
                .assertNext(actual -> {
                            assertEquals(exception1.toString(), actual.toString());
                        }
                )
                .verifyComplete();


        TOtpGenerateQrDto success = TOtpGenerateQrDto.builder()
                .statusCode("200")
                .statusDescription("QR Generated Successfully")
                .build();
        tOtpUserMasterDto.setStatus("A");
        doReturn(Mono.just(tOtpUserMasterDto)).when(this.tOtpUserMasterSPI)
                .findById(any());
        doReturn(Mono.just(tOtpUserMasterDto)).when(this.tOtpGenerateQrHelper)
                .canGenerateQr(any(TOtpUserMasterDto.class));
        doReturn(Mono.just(success)).when(this.tOtpGenerateQrHelper)
                .generateQr(any(), any());
        StepVerifier.create(tOtpUserUseCase.generateQr("TEST_SYSTEM", "TEST_USER"))
                .assertNext(actual -> {
                            assertEquals(success.toString(), actual.toString());
                        }
                )
                .verifyComplete();
    }


}