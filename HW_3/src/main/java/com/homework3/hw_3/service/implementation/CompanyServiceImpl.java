package com.homework3.hw_3.service.implementation;

import com.homework3.hw_3.entity.Company;
import com.homework3.hw_3.entity.dto.CompanyDTO;
import com.homework3.hw_3.service.inter.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
public class CompanyServiceImpl implements CompanyService {

    @Override
    public List<CompanyDTO> geAllCompanies() {
        log.info("Get all companies");
        return new ArrayList<CompanyDTO>();
    }
}
