package com.homework4.hw_4.mappers;

import com.homework4.hw_4.entity.Company;
import com.homework4.hw_4.entity.dto.CompanyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CompanyMapper {
    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    CompanyDTO toDTO(Company company);

    Company fromDTO(CompanyDTO companyDTO);
}
