package com.homework4.hw_4.mappers;

import com.homework4.hw_4.entity.Liner;
import com.homework4.hw_4.entity.dto.LinerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LinerMapper {

    LinerMapper INSTANCE = Mappers.getMapper(LinerMapper.class);

    LinerDTO toDTO(Liner liner);

    Liner fromDTO(LinerDTO linerDTO);

}
