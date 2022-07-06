package com.homework3.hw_3.controller;

import com.homework3.hw_3.entity.dto.CompanyDTO;
import com.homework3.hw_3.service.inter.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController(value = "/company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public List<CompanyDTO> getAllCompanies() {
        log.info("Get all companies");
        return companyService.geAllCompanies();
    }
}
