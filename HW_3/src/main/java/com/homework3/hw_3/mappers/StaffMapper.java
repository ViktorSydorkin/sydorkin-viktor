package com.homework3.hw_3.mappers;
import com.homework3.hw_3.entity.Staff;
import com.homework3.hw_3.entity.User;
import com.homework3.hw_3.entity.dto.StaffDTO;
import com.homework3.hw_3.entity.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StaffMapper {
    StaffMapper INSTANCE = Mappers.getMapper(StaffMapper.class);
    StaffDTO toDTO(Staff staff);
    Staff fromDTO(StaffDTO staffDTO);
}
