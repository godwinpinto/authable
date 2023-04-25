package com.github.godwinpinto.authable.domain.totp.usecase;

import com.github.godwinpinto.authable.domain.totp.dto.*;
import com.github.godwinpinto.authable.domain.totp.ports.api.TOtpUserServiceAPI;
import com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpUserMasterSPI;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class TOtpUserUseCase implements TOtpUserServiceAPI {

  TOtpUserMasterSPI tOtpUserMasterSPI;

  TOtpGetUserStatusHelper tOtpGetUserStatusHelper;

  TOtpUnBlockUserHelper tOtpUnBlockUserHelper;

  TOtpCreateSecretHelper tOtpCreateSecretHelper;

  TOtpGenerateQrHelper tOtpGenerateQrHelper;

  TOtpUnSubscribeUserHelper tOtpUnSubscribeUserHelper;

  TOtpVerifyHelper tOtpVerifyHelper;

  public TOtpUserUseCase(
      TOtpUserMasterSPI tOtpUserMasterSPI,
      TOtpGetUserStatusHelper tOtpGetUserStatusHelper,
      TOtpUnBlockUserHelper tOtpUnBlockUserHelper,
      TOtpCreateSecretHelper tOtpCreateSecretHelper,
      TOtpGenerateQrHelper tOtpGenerateQrHelper,
      TOtpUnSubscribeUserHelper tOtpUnSubscribeUserHelper,
      TOtpVerifyHelper tOtpVerifyHelper) {
    this.tOtpUserMasterSPI = tOtpUserMasterSPI;
    this.tOtpGetUserStatusHelper = tOtpGetUserStatusHelper;
    this.tOtpUnBlockUserHelper = tOtpUnBlockUserHelper;
    this.tOtpCreateSecretHelper = tOtpCreateSecretHelper;
    this.tOtpGenerateQrHelper = tOtpGenerateQrHelper;
    this.tOtpUnSubscribeUserHelper = tOtpUnSubscribeUserHelper;
    this.tOtpVerifyHelper = tOtpVerifyHelper;
  }

  @Override
  public Mono<TOtpUserStatusDto> getUserStatus(String systemId, String userId) {
    String userSystemId = systemId + userId;
    return tOtpUserMasterSPI
        .findById(userSystemId)
        .flatMap(tOtpGetUserStatusHelper::userStatusFromDatabase)
        .switchIfEmpty(Mono.defer(() -> tOtpGetUserStatusHelper.recordNotFound()));
  }

  @Override
  public Mono<TOtpUnBlockUserDto> unBlockUser(String systemId, String userId) {
    String userSystemId = systemId + userId;
    return tOtpUserMasterSPI
        .findById(userSystemId)
        .flatMap(
            user -> {
              if (Boolean.TRUE.equals(tOtpUnBlockUserHelper.isUserDisabledOrActive(user)))
                return tOtpUnBlockUserHelper.changeFlagInDatabase(userSystemId, user);
              else return tOtpUnBlockUserHelper.formatNoSubscriptionMessage();
            })
        .switchIfEmpty(tOtpUnBlockUserHelper.formatNoSubscriptionMessage())
        .onErrorResume(tOtpUnBlockUserHelper::fallbackMethod);
  }

  @Override
  public Mono<TOtpCreateNewDto> createTOtpSecret(String systemId, String userId) {
    String userSystemId = systemId + userId;
    return tOtpUserMasterSPI
        .findById(userSystemId)
        .flatMap(tOtpCreateSecretHelper::isAllowedToReset)
        .flatMap(user -> tOtpCreateSecretHelper.updateDbToReset(userSystemId, user))
        .switchIfEmpty(
            Mono.defer(() -> tOtpCreateSecretHelper.createNewRecord(systemId, userSystemId)))
        .onErrorResume(tOtpCreateSecretHelper::fallbackMethod);
  }

  @Override
  public Mono<TOtpGenerateQrDto> generateQr(String systemId, String userId) {
    String userSystemId = systemId + userId;
    return tOtpUserMasterSPI
        .findById(userSystemId)
        .flatMap(tOtpGenerateQrHelper::canGenerateQr)
        .flatMap(user -> tOtpGenerateQrHelper.generateQr(userSystemId, user))
        .switchIfEmpty(tOtpGenerateQrHelper.formatNoSubscriptionMessage())
        .onErrorResume(tOtpGenerateQrHelper::fallbackMethod);
  }

  @Override
  public Mono<TOtpUnSubscribeUserDto> unSubscribe(String systemId, String userId) {
    String userSystemId = systemId + userId;
    return tOtpUserMasterSPI
        .findById(userSystemId)
        .flatMap(tOtpUnSubscribeUserHelper::isUserDisabledOrNonActive)
        .flatMap(user -> tOtpUnSubscribeUserHelper.updateDbToUnsubscribe(userSystemId))
        .switchIfEmpty(tOtpUnSubscribeUserHelper.formatNoRecordFoundMessage())
        .onErrorResume(tOtpUnSubscribeUserHelper::fallbackMethod);
  }

  @Override
  public Mono<TOtpVerifyDto> verify(String systemId, String userId, String otp) {
    String userSystemId = systemId + userId;
    return tOtpUserMasterSPI
        .findById(userSystemId)
        .flatMap(tOtpVerifyHelper::isUserNotActive)
        .flatMap(user -> tOtpVerifyHelper.verifyAndUpdateOtp(otp, userSystemId, user))
        .switchIfEmpty(tOtpVerifyHelper.formatNoSubscriptionMessage())
        .onErrorResume(tOtpVerifyHelper::fallbackMethod);
  }
}
