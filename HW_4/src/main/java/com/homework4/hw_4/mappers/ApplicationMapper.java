package com.homework4.hw_4.mappers;

import com.homework4.hw_4.entity.Application;
import com.homework4.hw_4.entity.dto.ApplicationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ApplicationMapper {

    ApplicationMapper INSTANCE = Mappers.getMapper(ApplicationMapper.class);

    ApplicationDTO toDTO(Application application);

    Application fromDTO(ApplicationDTO applicationDTO);

}
