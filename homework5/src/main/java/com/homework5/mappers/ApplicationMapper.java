package com.homework5.mappers;

import com.homework5.entity.Application;
import com.homework5.entity.dto.ApplicationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ApplicationMapper {

    ApplicationMapper INSTANCE = Mappers.getMapper(ApplicationMapper.class);

    ApplicationDTO toDTO(Application application);

    Application fromDTO(ApplicationDTO applicationDTO);

}
