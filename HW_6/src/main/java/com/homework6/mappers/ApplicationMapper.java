package com.homework6.mappers;

import com.homework6.entity.Application;
import com.homework6.entity.dto.ApplicationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ApplicationMapper {

    ApplicationMapper INSTANCE = Mappers.getMapper(ApplicationMapper.class);

    ApplicationDTO toDTO(Application application);

    Application fromDTO(ApplicationDTO applicationDTO);

}
