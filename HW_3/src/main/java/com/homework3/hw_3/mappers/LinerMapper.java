package com.homework3.hw_3.mappers;

import com.homework3.hw_3.entity.Liner;
import com.homework3.hw_3.entity.dto.LinerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LinerMapper {
    LinerMapper INSTANCE = Mappers.getMapper(LinerMapper.class);

    LinerDTO toDTO(Liner liner);

    Liner fromDTO(LinerDTO linerDTO);
}
