package com.github.godwinpinto.authable.application.rest.totp.controller;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.github.godwinpinto.authable.commons.auth.config.FetchPrincipalComponent;
import com.github.godwinpinto.authable.domain.totp.ports.api.TOtpUserServiceAPI;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.validation.Validator;

@ContextConfiguration(
    classes = {
      TOtpRoutesConfig.class,
      TOtpStatusHandler.class,
      TOtpVerifyHandler.class,
      TOtpUnBlockHandler.class,
      TOtpUnSubscribeHandler.class,
      TOtpGenerateQrHandler.class,
      TOtpSubscribeHandler.class,
      FetchPrincipalComponent.class
    })
@ExtendWith(SpringExtension.class)
class TOtpRoutesConfigTest {
  @Autowired private TOtpGenerateQrHandler tOtpGenerateQrHandler;

  @Autowired private TOtpRoutesConfig tOtpRoutesConfig;

  @Autowired private TOtpStatusHandler tOtpStatusHandler;

  @Autowired private TOtpSubscribeHandler tOtpSubscribeHandler;

  @Autowired private TOtpUnBlockHandler tOtpUnBlockHandler;

  @Autowired private TOtpUnSubscribeHandler tOtpUnSubscribeHandler;

  @MockBean private TOtpUserServiceAPI tOtpUserServiceAPI;

  @Autowired private TOtpVerifyHandler tOtpVerifyHandler;

  @MockBean private Validator validator;

  /**
   * Method under test: {@link TOtpRoutesConfig#getStatus(TOtpStatusHandler, TOtpVerifyHandler,
   * TOtpUnBlockHandler, TOtpUnSubscribeHandler, TOtpGenerateQrHandler, TOtpSubscribeHandler)}
   */
  @Test
  void testGetStatus() {
    assertDoesNotThrow(()->
    tOtpRoutesConfig.getStatus(
        tOtpStatusHandler,
        tOtpVerifyHandler,
        tOtpUnBlockHandler,
        tOtpUnSubscribeHandler,
        tOtpGenerateQrHandler,
        tOtpSubscribeHandler));
  }
}
