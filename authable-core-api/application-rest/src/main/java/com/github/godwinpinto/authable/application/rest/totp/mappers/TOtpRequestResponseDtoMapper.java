package com.github.godwinpinto.authable.application.rest.totp.mappers;

import com.github.godwinpinto.authable.application.rest.totp.json.CreateNewTOtpResponse;
import com.github.godwinpinto.authable.application.rest.totp.json.GenerateQrResponse;
import com.github.godwinpinto.authable.application.rest.totp.json.GenericResponse;
import com.github.godwinpinto.authable.domain.totp.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TOtpRequestResponseDtoMapper {
    TOtpRequestResponseDtoMapper INSTANCE = Mappers.getMapper(TOtpRequestResponseDtoMapper.class);

    CreateNewTOtpResponse createNewResponseFromDto(TOtpCreateNewDto tOtpCreateNewDto);

    GenericResponse unblockResponseFromDto(TOtpUnBlockUserDto tOtpUnBlockUserDto);

    GenericResponse unSubscribeResponseFromDto(TOtpUnSubscribeUserDto tOtpUnSubscribeUserDto);

    GenericResponse statusResponseFromDto(TOtpUserStatusDto tOtpUserStatusDto);

    GenericResponse verifyResponseFromDto(TOtpVerifyDto tOtpVerifyDto);

    GenerateQrResponse generateQrResponseFromDto(TOtpGenerateQrDto tOtpGenerateQrDto);

}
