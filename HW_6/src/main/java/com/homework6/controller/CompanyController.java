package com.homework6.controller;

import com.homework6.entity.dto.CompanyDTO;
import com.homework6.entity.exception.ControllerException;
import com.homework6.entity.exception.ServiceException;
import com.homework6.service.inter.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/company")
    public List<CompanyDTO> getAllCompanies() {
        try {
            log.info("Get all companies");
            return companyService.geAllCompanies();
        } catch (ServiceException serviceException) {
            throw new ControllerException(serviceException.getMessage());
        }
    }
}
