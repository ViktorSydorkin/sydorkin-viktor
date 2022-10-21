package com.homework5.mappers;

import com.homework5.entity.Company;
import com.homework5.entity.dto.CompanyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CompanyMapper {

    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    CompanyDTO toDTO(Company company);

    Company fromDTO(CompanyDTO companyDTO);

}
