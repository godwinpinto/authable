package com.github.godwinpinto.authable.domain.totp.usecase;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.github.godwinpinto.authable.commons.exception.NonFatalException;
import com.github.godwinpinto.authable.domain.totp.dto.TOtpUserMasterDto;
import com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpUserMasterSPI;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ContextConfiguration(classes = {TOtpUnSubscribeUserHelper.class})
@ExtendWith(SpringExtension.class)
class TOtpUnSubscribeUserHelperTest {
  @Autowired private TOtpUnSubscribeUserHelper tOtpUnSubscribeUserHelper;

  @MockBean private TOtpUserMasterSPI tOtpUserMasterSPI;

  /**
   * Method under test: {@link
   * TOtpUnSubscribeUserHelper#isUserDisabledOrNonActive(TOtpUserMasterDto)}
   */
  @Test
  void testIsUserDisabledOrNonActive() {
    TOtpUserMasterDto user = mock(TOtpUserMasterDto.class);
    when(user.getStatus()).thenReturn("Status");
    tOtpUnSubscribeUserHelper.isUserDisabledOrNonActive(user);
    verify(user, atLeast(1)).getStatus();
  }

  /**
   * Method under test: {@link
   * TOtpUnSubscribeUserHelper#isUserDisabledOrNonActive(TOtpUserMasterDto)}
   */
  @Test
  void testIsUserDisabledOrNonActive2() {
    TOtpUserMasterDto user = mock(TOtpUserMasterDto.class);
    when(user.getStatus()).thenReturn("N");
    tOtpUnSubscribeUserHelper.isUserDisabledOrNonActive(user);
    verify(user).getStatus();
  }

  /**
   * Method under test: {@link
   * TOtpUnSubscribeUserHelper#isUserDisabledOrNonActive(TOtpUserMasterDto)}
   */
  @Test
  void testIsUserDisabledOrNonActive3() {
    TOtpUserMasterDto user = mock(TOtpUserMasterDto.class);
    when(user.getStatus()).thenReturn("A");
    tOtpUnSubscribeUserHelper.isUserDisabledOrNonActive(user);
    verify(user, atLeast(1)).getStatus();
  }

  /** Method under test: {@link TOtpUnSubscribeUserHelper#updateDbToUnsubscribe(String)} */
  @Test
  void testUpdateDbToUnsubscribe2() {
    when(tOtpUserMasterSPI.removeDisabledStatus(
            Mockito.any(), Mockito.any(), Mockito.any()))
        .thenThrow(new RuntimeException());
    assertThrows(
        RuntimeException.class, () -> tOtpUnSubscribeUserHelper.updateDbToUnsubscribe("42"));
    verify(tOtpUserMasterSPI)
        .removeDisabledStatus(
            Mockito.any(), Mockito.any(), Mockito.any());
  }

  @Test
  void fallbackMethod_Test() {

    NonFatalException nfe = new NonFatalException("300", "Sample Exception");

    Exception e = new Exception("Sample Other Exception");

    StepVerifier.create(tOtpUnSubscribeUserHelper.fallbackMethod(nfe))
        .assertNext(
            tOtpUnBlockUserDto -> {
              assertEquals(tOtpUnBlockUserDto.getStatusDescription(), nfe.getMessage());
              assertEquals(tOtpUnBlockUserDto.getStatusCode(), nfe.getErrCode());
            })
        .verifyComplete();

    StepVerifier.create(tOtpUnSubscribeUserHelper.fallbackMethod(e))
        .assertNext(
            tOtpUnBlockUserDto -> {
              assertEquals("Unknown error occurred", tOtpUnBlockUserDto.getStatusDescription());
            })
        .verifyComplete();
  }

  @Test
  void updateDbToUnsubscribe_Flow_Test() {
    doReturn(Mono.just(1L)).when(tOtpUserMasterSPI).removeDisabledStatus(any(), any(), any());
    StepVerifier.create(tOtpUnSubscribeUserHelper.updateDbToUnsubscribe("TEST_SYSTEM_TEST_USER"))
        .assertNext(
            tOtpUnBlockUserDto -> {
              assertEquals(
                  "TOTP subscription cancelled for user",
                  tOtpUnBlockUserDto.getStatusDescription());
            })
        .verifyComplete();

    doReturn(Mono.just(0L)).when(tOtpUserMasterSPI).removeDisabledStatus(any(), any(), any());

    StepVerifier.create(tOtpUnSubscribeUserHelper.updateDbToUnsubscribe("TEST_SYSTEM_TEST_USER"))
        .expectErrorMatches(
            e -> e instanceof NonFatalException && e.getMessage().equals("Failure in updating"))
        .verify();

    doReturn(Mono.empty()).when(tOtpUserMasterSPI).removeDisabledStatus(any(), any(), any());

    StepVerifier.create(tOtpUnSubscribeUserHelper.updateDbToUnsubscribe("TEST_SYSTEM_TEST_USER"))
        .expectErrorMatches(
            e -> e instanceof NonFatalException && e.getMessage().equals("Failure in updating"))
        .verify();
  }

  @Test
  void formatNoRecordFoundMessage_Test() {
    assertDoesNotThrow(() -> tOtpUnSubscribeUserHelper.formatNoRecordFoundMessage());
  }
}
