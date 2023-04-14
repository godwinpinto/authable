package com.github.godwinpinto.authable.domain.totp.usecase;

import com.github.godwinpinto.authable.commons.constants.ApplicationConstants;
import com.github.godwinpinto.authable.commons.exception.NonFatalException;
import com.github.godwinpinto.authable.domain.totp.dto.TOtpGenerateQrDto;
import com.github.godwinpinto.authable.domain.totp.dto.TOtpUserMasterDto;
import com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpCryptoSPI;
import com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpUserMasterSPI;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;


@Component
public class TOtpGenerateQrHelper {

    TOtpUserMasterSPI tOtpUserMasterSPI;
    TOtpCryptoSPI tOtpCryptoSPI;

    TOtpGenerateQrHelper(TOtpUserMasterSPI tOtpUserMasterSPI, TOtpCryptoSPI tOtpCryptoSPI) {
        this.tOtpUserMasterSPI = tOtpUserMasterSPI;
        this.tOtpCryptoSPI = tOtpCryptoSPI;
    }

    Mono<TOtpUserMasterDto> canGenerateQr(TOtpUserMasterDto user) {
        if (user.getStatus()
                .equals(ApplicationConstants.RecordStatus.DISABLED.getValue())) {
            return Mono.error(new NonFatalException("300", "Your TOTP is disabled. Contact administrator"));
        } else if (user.getStatus()
                .equals(ApplicationConstants.RecordStatus.ACTIVE.getValue())) {
            return Mono.just(user);
        } else if (user.getStatus()
                .equals(ApplicationConstants.RecordStatus.INACTIVE.getValue())) {
            return Mono.error(new NonFatalException("300", "You are not subscribed to TOTP."));
        } else {
            return Mono.error(new NonFatalException("300", "Unknown error occurred. Please contact administrator"));
        }
    }

    public Mono<TOtpGenerateQrDto> generateQr(String userSystemId, TOtpUserMasterDto user) {
        String qrCode =
                tOtpCryptoSPI.generateQRCode(userSystemId, user.getUserSecret(),
                        "godwin.pinto86@gmail.com", "Sample App Name");
        return formatSuccessResponse(qrCode);
    }

    private Mono<TOtpGenerateQrDto> formatSuccessResponse(String qrCode) {
        return Mono.just(TOtpGenerateQrDto.builder()
                .statusCode("200")
                .statusDescription("QR Generated Successfully")
                .qrImage(qrCode)
                .build());
    }

    public Mono<TOtpGenerateQrDto> formatNoSubscriptionMessage() {
        return Mono.just(TOtpGenerateQrDto.builder()
                .statusCode("200")
                .statusDescription("No active subscription found for user")
                .build());
    }


    public Mono<TOtpGenerateQrDto> fallbackMethod(Throwable error) {
        if (error instanceof NonFatalException e) {
            return Mono.just(TOtpGenerateQrDto.builder()
                    .statusCode(e.getErrCode())
                    .statusDescription(e.getMessage())
                    .build());
        } else {
            return Mono.just(TOtpGenerateQrDto.builder()
                    .statusCode("500")
                    .statusDescription("Unknown error occurred")
                    .build());
        }
    }

}
