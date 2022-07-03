package com.homework3.hw_3.controller;

import com.homework3.hw_3.entity.Company;
import com.homework3.hw_3.entity.Cruise;
import com.homework3.hw_3.service.inter.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController(value = "/cruiseCompany")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/company")
    public List<Company> getAllCompanies() {
        log.info("Get all companies");
        return companyService.geAllCompanies();
    }
}
