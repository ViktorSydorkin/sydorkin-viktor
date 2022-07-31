package com.homework6.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.homework6.TestConfig;
import com.homework6.entity.dto.*;
import com.homework6.entity.enums.Paid;
import com.homework6.service.inter.ApplicationService;
import com.homework6.service.inter.CruiseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Import(TestConfig.class)
@WebMvcTest(ApplicationController.class)
class ApplicationControllerTest {

    @MockBean
    private ApplicationService applicationService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private
    ObjectMapper objectMapper;

    /*ROUTE*/
    private static final long ROUTE_ID1 = 1;
    private static final String START = "Start";
    private static final String END = "End";

    /*Liner*/
    private static final long LINER_ID1 = 1;
    private static final String NAME = "Name";
    private static final int DECK_AMOUNT = 1;
    private static final int CAPACITY = 1;

    /*Cruise*/
    private static final long CRUISE_ID1 = 1;
    private static final int PRICE = 1;
    private static final int AVAILABLE = 1;
    private static final Timestamp START_DATE= Timestamp.valueOf(LocalDateTime.now().plusDays(2).toString().substring(0, 22).replace("T", " "));
    private static final Timestamp END_DATE = Timestamp.valueOf(LocalDateTime.now().plusDays(3).toString().substring(0, 22).replace("T", " "));
    private static final RouteDTO ROUTE_DTO = RouteDTO.builder().id(ROUTE_ID1).start(START).end(END).port_amount(1).build();
    private static final LinerDTO LINER_DTO = LinerDTO.builder().id(LINER_ID1).name(NAME).deck_amount(DECK_AMOUNT).capacity(CAPACITY).build();

    /*User*/
    private static final long USER_ID = 1;
    private static final String USER_EMAIL1 = "email1@gmail.com";
    private static final String PASSWORD = "qwaszx123";
    private static final String USER_NAME = "Name";
    private static final String SURNAME = "Surname";
    private static final String ROLE = "User";

    /*Application*/
    private static final long APPLICATION_ID1 = 1;
    private static final long APPLICATION_ID2 = 2;
    private static final String MOCK_URL = "/application/";
    private static final String STATE = "PAID";
    private static final UserDTO USER_DTO = UserDTO.builder().id(USER_ID).email(USER_EMAIL1).password(PASSWORD).name(USER_NAME).surname(SURNAME).role(ROLE).build();
    private static final CruiseDTO CRUISE_DTO = CruiseDTO.builder().id(CRUISE_ID1).price(PRICE).available(AVAILABLE)
            .route(ROUTE_DTO).liner(LINER_DTO)
            .start(START_DATE).end(END_DATE).build();

    @Test
    void getApplicationById() throws Exception {
        ApplicationDTO applicationDTO = ApplicationDTO.builder().id(APPLICATION_ID1).cruise(CRUISE_DTO).user(USER_DTO).build();

        when(applicationService.getApplicationById(APPLICATION_ID1)).thenReturn(applicationDTO);

        mockMvc.perform(
                        get(MOCK_URL + APPLICATION_ID1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(APPLICATION_ID1));
    }

    @Test
    void getAllApplications() throws Exception {
        ApplicationDTO applicationDTO1 = ApplicationDTO.builder().id(APPLICATION_ID1).cruise(CRUISE_DTO).user(USER_DTO).build();
        ApplicationDTO applicationDTO2 = ApplicationDTO.builder().id(APPLICATION_ID2).cruise(CRUISE_DTO).user(USER_DTO).build();
        List<ApplicationDTO> applicationDTOList = List.of(applicationDTO1, applicationDTO2);

        when(applicationService.getAllApplications()).thenReturn(applicationDTOList);

        mockMvc.perform(
                        get(MOCK_URL))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(APPLICATION_ID1))
                .andExpect(jsonPath("$[1].id").value(APPLICATION_ID2));
    }

    @Test
    void createApplication() throws Exception {
        ApplicationDTO applicationDTO = ApplicationDTO.builder().id(APPLICATION_ID1).cruise(CRUISE_DTO).user(USER_DTO).build();

        doNothing().when(applicationService).saveApplication(applicationDTO);

        mockMvc.perform(
                        post(MOCK_URL).contentType("application/json")
                                .content(objectMapper.writeValueAsString(applicationDTO)))
                .andDo(print())
                .andExpect(status().isCreated());

        verify(applicationService).saveApplication(applicationDTO);
    }

    @Test
    void createInvalidApplicationUser() throws Exception {
        ApplicationDTO applicationDTO = ApplicationDTO.builder().id(APPLICATION_ID1).cruise(CRUISE_DTO).user(null).build();

        doNothing().when(applicationService).saveApplication(applicationDTO);

        mockMvc.perform(
                        post(MOCK_URL).contentType("application/json")
                                .content(objectMapper.writeValueAsString(applicationDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void createInvalidApplicationCruise() throws Exception {
        ApplicationDTO applicationDTO = ApplicationDTO.builder().id(APPLICATION_ID1).cruise(null).user(USER_DTO).build();

        doNothing().when(applicationService).saveApplication(applicationDTO);

        mockMvc.perform(
                        post(MOCK_URL).contentType("application/json")
                                .content(objectMapper.writeValueAsString(applicationDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void changeApplication() throws Exception {
        doNothing().when(applicationService).changeApplication(APPLICATION_ID1, STATE);

        mockMvc.perform(
                        patch(MOCK_URL+APPLICATION_ID1).contentType("application/json")
                                .content(objectMapper.writeValueAsBytes(STATE)))
                .andDo(print())
                .andExpect(status().isOk());

        verify(applicationService).changeApplication(APPLICATION_ID1, STATE);
    }

    @Test
    void updateApplication() throws Exception {
        ApplicationDTO applicationDTO = ApplicationDTO.builder().id(APPLICATION_ID1).cruise(CRUISE_DTO).user(USER_DTO).build();

        doNothing().when(applicationService).saveApplication(applicationDTO);

        mockMvc.perform(
                        put(MOCK_URL).contentType("application/json")
                                .content(objectMapper.writeValueAsString(applicationDTO)))
                .andDo(print())
                .andExpect(status().isOk());

        verify(applicationService).saveApplication(applicationDTO);
    }

    @Test
    void deleteApplication() throws Exception {
        doNothing().when(applicationService).deleteApplication(APPLICATION_ID1);

        mockMvc.perform(
                        delete(MOCK_URL + APPLICATION_ID1))
                .andDo(print())
                .andExpect(status().isOk());

        verify(applicationService).deleteApplication(APPLICATION_ID1);
    }
}