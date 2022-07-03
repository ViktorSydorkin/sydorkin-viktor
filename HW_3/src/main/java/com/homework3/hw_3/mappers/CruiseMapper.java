package com.homework3.hw_3.mappers;
import com.homework3.hw_3.entity.Cruise;
import com.homework3.hw_3.entity.User;
import com.homework3.hw_3.entity.dto.CruiseDTO;
import com.homework3.hw_3.entity.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CruiseMapper {
    CruiseMapper INSTANCE = Mappers.getMapper(CruiseMapper.class);
    CruiseDTO toDTO(Cruise cruise);
    Cruise fromDTO(CruiseDTO cruiseDTO);
}
