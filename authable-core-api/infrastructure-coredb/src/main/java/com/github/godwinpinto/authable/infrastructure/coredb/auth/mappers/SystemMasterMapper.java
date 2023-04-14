package com.github.godwinpinto.authable.infrastructure.coredb.auth.mappers;

import com.github.godwinpinto.authable.domain.auth.dto.SystemMasterDto;
import com.github.godwinpinto.authable.infrastructure.coredb.auth.entity.SystemMasterEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SystemMasterMapper {
    SystemMasterMapper INSTANCE = Mappers.getMapper(SystemMasterMapper.class);

    SystemMasterDto systemMasterToDto(SystemMasterEntity systemMasterEntity);

}
