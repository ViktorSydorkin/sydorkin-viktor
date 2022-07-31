package com.homework6.service.implementation;

import com.homework6.entity.Company;
import com.homework6.repository.inter.CompanyRepository;
import com.homework6.repository.inter.LinerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CompanyServiceImplTest {

    @Mock
    CompanyRepository companyRepository;

    @InjectMocks
    CompanyServiceImpl companyService;

    private final static long MOCKED_ID1 = 1L;
    private final static long MOCKED_ID2 = 2L;

    @Test
    void geAllCompanies() {
        Company company1 = Company.builder().id(MOCKED_ID1).build();
        Company company2 = Company.builder().id(MOCKED_ID2).build();
        List<Company> companyList = List.of(company1, company2);
        when(companyRepository.findAll()).thenReturn(companyList);

        assertThat(companyService.geAllCompanies(), hasSize(2));
    }
}