package com.homework6.service.implementation;

import com.homework6.entity.dto.CompanyDTO;
import com.homework6.entity.exception.RepositoryException;
import com.homework6.entity.exception.ServiceException;
import com.homework6.mappers.CompanyMapper;
import com.homework6.repository.inter.CompanyRepository;
import com.homework6.service.inter.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public List<CompanyDTO> geAllCompanies() {
        log.info("Get all companies");
        try {
            return companyRepository.findAll().stream().map(CompanyMapper.INSTANCE::toDTO).collect(Collectors.toList());
        } catch (RepositoryException r) {
            log.error("Repository has thrown an exception { }", r);
            throw new ServiceException(r.getMessage());
        }
    }
}
