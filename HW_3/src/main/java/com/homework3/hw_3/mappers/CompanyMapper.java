package com.homework3.hw_3.mappers;

import com.homework3.hw_3.entity.Company;
import com.homework3.hw_3.entity.dto.CompanyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CompanyMapper {
    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    CompanyDTO toDTO(Company company);

    Company fromDTO(CompanyDTO companyDTO);
}
