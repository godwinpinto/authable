package com.github.godwinpinto.authable.infrastructure.coredb.auth.mappers;

import com.github.godwinpinto.authable.domain.auth.dto.SystemUserMasterDto;
import com.github.godwinpinto.authable.infrastructure.coredb.auth.entity.SystemUserMasterEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SystemUserMasterMapper {
    SystemUserMasterMapper INSTANCE = Mappers.getMapper(SystemUserMasterMapper.class);

    SystemUserMasterDto systemUserMasterToDto(SystemUserMasterEntity systemUserMasterEntity);

}
