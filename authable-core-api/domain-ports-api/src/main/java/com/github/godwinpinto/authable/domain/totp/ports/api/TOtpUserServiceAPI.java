package com.github.godwinpinto.authable.domain.totp.ports.api;

import com.github.godwinpinto.authable.domain.totp.dto.*;
import reactor.core.publisher.Mono;

public interface TOtpUserServiceAPI {
    /**
     * Fetch if the user has an active Time based OTP registered.
     * A- Active
     * N-Not registered
     * D-Disabled
     *
     * @param systemId
     * @param userId
     * @return
     */
    Mono<TOtpUserStatusDto> getUserStatus(String systemId, String userId);

    /**
     * To be accessible only to admin and changes status from D- Disabled to N - Not Active
     *
     * @param systemId
     * @param userId
     * @return
     */
    Mono<TOtpUnBlockUserDto> unBlockUser(String systemId, String userId);

    /**
     * Generate a new TOTP secret, if one exists then disable previous and generate new
     *
     * @param systemId
     * @param userId
     * @return
     */
    Mono<TOtpCreateNewDto> createTOtpSecret(String systemId, String userId);

    /**
     * Generates QR Image for the existing TOTP secret
     *
     * @param systemId
     * @param userId
     * @return
     */
    Mono<TOtpGenerateQrDto> generateQr(String systemId, String userId);

    /**
     * Deregister an active registered TOTP
     *
     * @param systemId
     * @param userId
     * @return
     */
    Mono<TOtpUnSubscribeUserDto> unSubscribe(String systemId, String userId);

    /**
     * Verify the TOTP sent by user/ front-end system and the generated TOTP from server
     *
     * @param systemId
     * @param userId
     * @param otp
     * @return
     */
    Mono<TOtpVerifyDto> verify(String systemId, String userId, String otp);

}
