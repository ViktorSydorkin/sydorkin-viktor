package com.homework4.hw_4.mappers;

import com.homework4.hw_4.entity.Staff;
import com.homework4.hw_4.entity.dto.StaffDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StaffMapper {

    StaffMapper INSTANCE = Mappers.getMapper(StaffMapper.class);

    StaffDTO toDTO(Staff staff);

    Staff fromDTO(StaffDTO staffDTO);

}
