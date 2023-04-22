package com.github.godwinpinto.authable.domain.totp.usecase;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doReturn;

import com.github.godwinpinto.authable.commons.exception.NonFatalException;
import com.github.godwinpinto.authable.domain.totp.dto.TOtpUserMasterDto;
import com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpCryptoSPI;
import com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpUserMasterSPI;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ContextConfiguration(classes = {TOtpVerifyHelper.class})
@ExtendWith(SpringExtension.class)
@TestPropertySource(properties = {"domain.totp.max-failed-login-attempts=5"})
class TOtpVerifyHelperTest {
  @MockBean TOtpUserMasterSPI tOtpUserMasterSPI;
  @MockBean TOtpCryptoSPI tOtpCryptoSPI;
  @Autowired private TOtpVerifyHelper tOtpVerifyHelper;

  @Test
  void isUserNotActive_Active_Test() {

    TOtpUserMasterDto user = TOtpUserMasterDto.builder().status("A").userId("1234").build();
    StepVerifier.create(tOtpVerifyHelper.isUserNotActive(user))
        .assertNext(userResponse -> assertEquals(userResponse.getUserId(), user.getUserId()))
        .verifyComplete();
  }

  @Test
  void isUserNotActive_NotActive_Test() {

    TOtpUserMasterDto user = TOtpUserMasterDto.builder().status("N").userId("1234").build();
    StepVerifier.create(tOtpVerifyHelper.isUserNotActive(user))
        .expectErrorMatches(
            e ->
                e instanceof NonFatalException
                    && e.getMessage().equals("Access is inactive or disabled for the user"))
        .verify();
  }

  @Test
  void formatNoRecordFoundMessage_Test() {
    assertDoesNotThrow(() -> tOtpVerifyHelper.formatNoSubscriptionMessage());
  }

  @Test
  void fallbackMethod_Test() {

    NonFatalException nfe = new NonFatalException("300", "Sample Exception");

    Exception e = new Exception("Sample Other Exception");

    StepVerifier.create(tOtpVerifyHelper.fallbackMethod(nfe))
        .assertNext(
            tOtpVerifyDto -> {
              assertEquals(tOtpVerifyDto.getStatusDescription(), nfe.getMessage());
              assertEquals(tOtpVerifyDto.getStatusCode(), nfe.getErrCode());
            })
        .verifyComplete();

    StepVerifier.create(tOtpVerifyHelper.fallbackMethod(e))
        .assertNext(
            tOtpVerifyDto -> {
              assertEquals(tOtpVerifyDto.getStatusDescription(), "Unknown error occurred");
            })
        .verifyComplete();
  }

  @Test
  void verifyAndUpdateOtp_Flow_Test() {

    TOtpUserMasterDto user = TOtpUserMasterDto.builder().status("N").userId("1234").build();
    doReturn(true).when(tOtpCryptoSPI).verify(any(), any(), any());

    doReturn(Mono.justOrEmpty(1L))
        .when(tOtpUserMasterSPI)
        .updateLoginSuccess(any(), any(LocalDateTime.class));

    StepVerifier.create(tOtpVerifyHelper.verifyAndUpdateOtp("123456", "TEST_SYSTEM", user))
        .assertNext(
            tOtpVerifyDto -> {
              assertEquals(tOtpVerifyDto.getStatusDescription(), "Verification successful");
            })
        .verifyComplete();
    doReturn(Mono.justOrEmpty(0L))
        .when(tOtpUserMasterSPI)
        .updateLoginSuccess(any(), any(LocalDateTime.class));

    StepVerifier.create(tOtpVerifyHelper.verifyAndUpdateOtp("123456", "TEST_SYSTEM", user))
        .expectErrorMatches(
            e ->
                e instanceof NonFatalException
                    && e.getMessage().equals("Error in updating database"))
        .verify();

    doReturn(false).when(tOtpCryptoSPI).verify(any(), any(), any());

    doReturn(Mono.just(1L))
        .when(tOtpUserMasterSPI)
        .updateInvalidAttempt(any(), any(short.class), any(LocalDateTime.class));

    StepVerifier.create(tOtpVerifyHelper.verifyAndUpdateOtp("123456", "TEST_SYSTEM", user))
        .expectErrorMatches(
            e ->
                e instanceof NonFatalException
                    && e.getMessage().equals("Invalid OTP. Please try again."))
        .verify();

    user.setNoOfAttempts((short) 4);
    ReflectionTestUtils.setField(this.tOtpVerifyHelper, "maxFailedAttempts", 5);

    doReturn(Mono.just(1L)).when(tOtpUserMasterSPI).updateDisable(any(), any(), any());
    StepVerifier.create(tOtpVerifyHelper.verifyAndUpdateOtp("123456", "TEST_SYSTEM", user))
        .expectErrorMatches(
            e -> e instanceof NonFatalException && e.getMessage().equals("Account has been locked"))
        .verify();
  }
}
