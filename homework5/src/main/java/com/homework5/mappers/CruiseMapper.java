package com.homework5.mappers;

import com.homework5.entity.Cruise;
import com.homework5.entity.dto.CruiseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CruiseMapper {

    CruiseMapper INSTANCE = Mappers.getMapper(CruiseMapper.class);

    CruiseDTO toDTO(Cruise cruise);

    Cruise fromDTO(CruiseDTO cruiseDTO);

}
