package com.github.godwinpinto.authable.domain.totp.usecase;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.github.godwinpinto.authable.commons.exception.NonFatalException;
import com.github.godwinpinto.authable.domain.totp.dto.TOtpUserMasterDto;
import com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpUserMasterSPI;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ContextConfiguration(classes = {TOtpUnBlockUserHelper.class})
@ExtendWith(SpringExtension.class)
class TOtpUnBlockUserHelperTest {
  @Autowired private TOtpUnBlockUserHelper tOtpUnBlockUserHelper;

  @MockBean private TOtpUserMasterSPI tOtpUserMasterSPI;

  /** Method under test: {@link TOtpUnBlockUserHelper#isUserDisabledOrActive(TOtpUserMasterDto)} */
  @Test
  void testIsUserDisabledOrActive() {
    TOtpUserMasterDto user = mock(TOtpUserMasterDto.class);
    when(user.getStatus()).thenReturn("Status");
    assertFalse(tOtpUnBlockUserHelper.isUserDisabledOrActive(user));
    verify(user).getStatus();
  }

  /** Method under test: {@link TOtpUnBlockUserHelper#isUserDisabledOrActive(TOtpUserMasterDto)} */
  @Test
  void testIsUserDisabledOrActive2() {
    TOtpUserMasterDto user = mock(TOtpUserMasterDto.class);
    when(user.getStatus()).thenReturn("N");
    assertTrue(tOtpUnBlockUserHelper.isUserDisabledOrActive(user));
    verify(user).getStatus();
  }

  @Test
  void fallbackMethod_Test() {

    NonFatalException nfe = new NonFatalException("300", "Sample Exception");

    Exception e = new Exception("Sample Other Exception");

    StepVerifier.create(tOtpUnBlockUserHelper.fallbackMethod(nfe))
        .assertNext(
            tOtpUnBlockUserDto -> {
              assertEquals(tOtpUnBlockUserDto.getStatusDescription(), nfe.getMessage());
              assertEquals(tOtpUnBlockUserDto.getStatusCode(), nfe.getErrCode());
            })
        .verifyComplete();

    StepVerifier.create(tOtpUnBlockUserHelper.fallbackMethod(e))
        .assertNext(
            tOtpUnBlockUserDto -> {
              assertEquals(tOtpUnBlockUserDto.getStatusDescription(), "Unknown error occurred");
            })
        .verifyComplete();
  }

  @Test
  void changeFlagInDatabase_Test() {

    TOtpUserMasterDto userMasterDto = TOtpUserMasterDto.builder().status("A").build();
    doReturn(Mono.just(1L)).when(tOtpUserMasterSPI).removeDisabledStatus(any(), any(), any());

    StepVerifier.create(tOtpUnBlockUserHelper.changeFlagInDatabase("TEST_SYSTEM", userMasterDto))
        .assertNext(
            tOtpUnBlockUserDto -> {
              assertEquals(
                  tOtpUnBlockUserDto.getStatusDescription(),
                  "TOTP subscription cancelled for user");
            })
        .verifyComplete();

    doReturn(Mono.empty()).when(tOtpUserMasterSPI).removeDisabledStatus(any(), any(), any());

    StepVerifier.create(tOtpUnBlockUserHelper.changeFlagInDatabase("TEST_SYSTEM", userMasterDto))
        .expectErrorMatches(
            e -> e instanceof NonFatalException && e.getMessage().equals("Failure in updating"))
        .verify();

    userMasterDto.setStatus("D");
    doReturn(Mono.just(1L)).when(tOtpUserMasterSPI).removeDisabledStatus(any(), any(), any());

    StepVerifier.create(tOtpUnBlockUserHelper.changeFlagInDatabase("TEST_SYSTEM", userMasterDto))
        .assertNext(
            tOtpUnBlockUserDto -> {
              assertEquals(
                  tOtpUnBlockUserDto.getStatusDescription(), "User unblocked successfully.");
            })
        .verifyComplete();
  }

  @Test
  void formatNoSubscriptionMessage_Test() {
    StepVerifier.create(tOtpUnBlockUserHelper.formatNoSubscriptionMessage())
        .assertNext(
            tOtpUnBlockUserDto -> {
              assertEquals(
                  tOtpUnBlockUserDto.getStatusDescription(),
                  "No active subscription found for user");
            })
        .verifyComplete();
  }
}
