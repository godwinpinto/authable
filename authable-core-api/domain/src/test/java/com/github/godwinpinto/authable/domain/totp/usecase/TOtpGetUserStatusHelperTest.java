package com.github.godwinpinto.authable.domain.totp.usecase;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

import com.github.godwinpinto.authable.domain.totp.dto.TOtpUserMasterDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TOtpGetUserStatusHelper.class})
@ExtendWith(SpringExtension.class)
class TOtpGetUserStatusHelperTest {
  @Autowired private TOtpGetUserStatusHelper tOtpGetUserStatusHelper;

  /**
   * Method under test: {@link TOtpGetUserStatusHelper#userStatusFromDatabase(TOtpUserMasterDto)}
   */
  @Test
  void testUserStatusFromDatabase() {
    TOtpUserMasterDto user = mock(TOtpUserMasterDto.class);
    when(user.getStatus()).thenReturn("Status");
    tOtpGetUserStatusHelper.userStatusFromDatabase(user);
    verify(user, atLeast(1)).getStatus();
  }

  /**
   * Method under test: {@link TOtpGetUserStatusHelper#userStatusFromDatabase(TOtpUserMasterDto)}
   */
  @Test
  void testUserStatusFromDatabase2() {
    TOtpUserMasterDto user = mock(TOtpUserMasterDto.class);
    when(user.getStatus()).thenReturn("A");
    tOtpGetUserStatusHelper.userStatusFromDatabase(user);
    verify(user).getStatus();
  }

  /**
   * Method under test: {@link TOtpGetUserStatusHelper#userStatusFromDatabase(TOtpUserMasterDto)}
   */
  @Test
  void testUserStatusFromDatabase3() {
    TOtpUserMasterDto user = mock(TOtpUserMasterDto.class);
    when(user.getStatus()).thenReturn("N");
    tOtpGetUserStatusHelper.userStatusFromDatabase(user);
    verify(user, atLeast(1)).getStatus();
  }

  /** Method under test: {@link TOtpGetUserStatusHelper#recordNotFound()} */
  @Test
  void testRecordNotFound() {

    assertDoesNotThrow(()->tOtpGetUserStatusHelper.recordNotFound());
  }
}
