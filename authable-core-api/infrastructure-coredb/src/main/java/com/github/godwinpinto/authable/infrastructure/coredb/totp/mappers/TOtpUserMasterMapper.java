package com.github.godwinpinto.authable.infrastructure.coredb.totp.mappers;

import com.github.godwinpinto.authable.domain.totp.dto.TOtpUserMasterDto;
import com.github.godwinpinto.authable.infrastructure.coredb.totp.entity.TOtpUserMasterEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TOtpUserMasterMapper {
    TOtpUserMasterMapper INSTANCE = Mappers.getMapper(TOtpUserMasterMapper.class);

    TOtpUserMasterDto tOtpUserMasterToDto(TOtpUserMasterEntity tOtpUserMasterEntity);

    TOtpUserMasterEntity dtoToEntity(TOtpUserMasterDto tOtpUserMasterDto);

}
