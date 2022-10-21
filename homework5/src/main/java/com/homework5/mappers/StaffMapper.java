package com.homework5.mappers;

import com.homework5.entity.Staff;
import com.homework5.entity.dto.StaffDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StaffMapper {

    StaffMapper INSTANCE = Mappers.getMapper(StaffMapper.class);

    StaffDTO toDTO(Staff staff);

    Staff fromDTO(StaffDTO staffDTO);

}
