package com.homework6.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.homework6.TestConfig;
import com.homework6.entity.dto.LinerDTO;
import com.homework6.entity.dto.StaffDTO;
import com.homework6.service.inter.StaffService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Import(TestConfig.class)
@WebMvcTest(StaffController.class)
class StaffControllerTest {

    @MockBean
    private StaffService staffService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private
    ObjectMapper objectMapper;

    private static final long STAFF_ID1 = 1;
    private static final long STAFF_ID2 = 2;
    private static final String MOCK_URL = "/staff/";
    private static final String POST = "Cock";
    private static final String NAME = "Name";
    private static final String INVALID_NAME = "";
    private static final String SURNAME = "Surname";
    private static final LinerDTO LINER = LinerDTO.builder().id(STAFF_ID1).capacity(1).deck_amount(1).name(NAME).build();

    @Test
    void getAllStaff() throws Exception {
        StaffDTO staffDTO1 = StaffDTO.builder().id(STAFF_ID1).name(NAME).surname(SURNAME).post(POST).liner(LINER).build();
        StaffDTO staffDTO2 = StaffDTO.builder().id(STAFF_ID2).name(NAME).surname(SURNAME).post(POST).liner(LINER).build();
        List<StaffDTO> staffDTOS = List.of(staffDTO1, staffDTO2);

        when(staffService.getAllStaff()).thenReturn(staffDTOS);

        mockMvc.perform(
                        get(MOCK_URL))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(STAFF_ID1))
                .andExpect(jsonPath("$[1].id").value(STAFF_ID2));
    }

    @Test
    void createStaff() throws Exception {
        StaffDTO staffDTO1 = StaffDTO.builder().id(STAFF_ID1).name(NAME).surname(SURNAME).post(POST).liner(LINER).build();

        doNothing().when(staffService).saveStaff(staffDTO1);

        mockMvc.perform(
                        post(MOCK_URL).contentType("application/json")
                                .content(objectMapper.writeValueAsString(staffDTO1)))

                .andDo(print())
                .andExpect(status().isCreated());

        verify(staffService).saveStaff(staffDTO1);
    }

    @Test
    void createInvalidStaffName() throws Exception {
        StaffDTO staffDTO1 = StaffDTO.builder().id(STAFF_ID1).name(INVALID_NAME).surname(SURNAME).post(POST).liner(LINER).build();

        doNothing().when(staffService).saveStaff(staffDTO1);

        mockMvc.perform(
                        post(MOCK_URL).contentType("application/json")
                                .content(objectMapper.writeValueAsString(staffDTO1)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void createInvalidStaffSurname() throws Exception {
        StaffDTO staffDTO1 = StaffDTO.builder().id(STAFF_ID1).name(NAME).surname(INVALID_NAME).post(POST).liner(LINER).build();

        doNothing().when(staffService).saveStaff(staffDTO1);

        mockMvc.perform(
                        post(MOCK_URL).contentType("application/json")
                                .content(objectMapper.writeValueAsString(staffDTO1)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void createInvalidStaffPost() throws Exception {
        StaffDTO staffDTO1 = StaffDTO.builder().id(STAFF_ID1).name(NAME).surname(SURNAME).post(INVALID_NAME).liner(LINER).build();

        doNothing().when(staffService).saveStaff(staffDTO1);

        mockMvc.perform(
                        post(MOCK_URL).contentType("application/json")
                                .content(objectMapper.writeValueAsString(staffDTO1)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void createInvalidStaffLiner() throws Exception {
        StaffDTO staffDTO1 = StaffDTO.builder().id(STAFF_ID1).name(NAME).surname(SURNAME).post(POST).liner(null).build();

        doNothing().when(staffService).saveStaff(staffDTO1);

        mockMvc.perform(
                        post(MOCK_URL).contentType("application/json")
                                .content(objectMapper.writeValueAsString(staffDTO1)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void updateStaff() throws Exception {
        StaffDTO staffDTO1 = StaffDTO.builder().id(STAFF_ID1).name(NAME).surname(SURNAME).post(POST).liner(LINER).build();

        doNothing().when(staffService).saveStaff(staffDTO1);

        mockMvc.perform(
                        put(MOCK_URL).contentType("application/json")
                                .content(objectMapper.writeValueAsString(staffDTO1)))
                .andDo(print())
                .andExpect(status().isOk());

        verify(staffService).saveStaff(staffDTO1);
    }

    @Test
    void deleteStaff() throws Exception {
        doNothing().when(staffService).deleteStaff(STAFF_ID1);

        mockMvc.perform(
                        delete(MOCK_URL + STAFF_ID1))
                .andDo(print())
                .andExpect(status().isOk());

        verify(staffService).deleteStaff(STAFF_ID1);
    }
}