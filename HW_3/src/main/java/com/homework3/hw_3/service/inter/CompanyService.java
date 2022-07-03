package com.homework3.hw_3.service.inter;

import com.homework3.hw_3.entity.Company;
import com.homework3.hw_3.entity.dto.CompanyDTO;

import java.util.List;

public interface CompanyService {
    List<CompanyDTO> geAllCompanies();
}
