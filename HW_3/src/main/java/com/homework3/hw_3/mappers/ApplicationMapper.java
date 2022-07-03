package com.homework3.hw_3.mappers;
import com.homework3.hw_3.entity.Application;
import com.homework3.hw_3.entity.User;
import com.homework3.hw_3.entity.dto.ApplicationDTO;
import com.homework3.hw_3.entity.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ApplicationMapper {
    ApplicationMapper INSTANCE = Mappers.getMapper(ApplicationMapper.class);
    ApplicationDTO toDTO(Application application);
    Application fromDTO(ApplicationDTO applicationDTO);
}
