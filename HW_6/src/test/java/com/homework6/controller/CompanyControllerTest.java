package com.homework6.controller;

import com.homework6.TestConfig;
import com.homework6.entity.dto.CompanyDTO;
import com.homework6.service.inter.CompanyService;
import com.homework6.service.inter.RouteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@Import(TestConfig.class)
@WebMvcTest(CompanyController.class)
class CompanyControllerTest {

    @MockBean
    private CompanyService companyService;

    @Autowired
    private MockMvc mockMvc;

    private static final long COMPANY_ID1 = 1;
    private static final long COMPANY_ID2 = 2;
    private static final String MOCK_URL = "/company/";
    private static final String TITLE = "Title";

    @Test
    void getAllCompanies() throws Exception {
        CompanyDTO companyDTO1 = CompanyDTO.builder().id(COMPANY_ID1).title(TITLE).build();
        CompanyDTO companyDTO2 = CompanyDTO.builder().id(COMPANY_ID2).title(TITLE).build();
        List<CompanyDTO> companyDTOList = List.of(companyDTO1, companyDTO2);

        when(companyService.geAllCompanies()).thenReturn(companyDTOList);

        mockMvc.perform(
                        get(MOCK_URL))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(COMPANY_ID1))
                .andExpect(jsonPath("$[1].id").value(COMPANY_ID2));
    }
}