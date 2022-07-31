package com.homework6.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.homework6.TestConfig;
import com.homework6.entity.dto.LinerDTO;
import com.homework6.service.inter.LinerService;
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
@WebMvcTest(LinerController.class)
class LinerControllerTest {

    @MockBean
    private LinerService linerService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private
    ObjectMapper objectMapper;

    private static final long LINER_ID1 = 1;
    private static final long LINER_ID2 = 2;
    private static final String MOCK_URL = "/liner/";
    private static final String NAME = "Name";
    private static final String INVALID_NAME = "";
    private static final int DECK_AMOUNT = 1;
    private static final int INVALID_DECK_AMOUNT = 0;
    private static final int CAPACITY = 1;
    private static final int INVALID_CAPACITY = -1;

    @Test
    void getLinerById() throws Exception {
        LinerDTO linerDTO = LinerDTO.builder().id(LINER_ID1).name(NAME).deck_amount(DECK_AMOUNT).capacity(CAPACITY).build();

        when(linerService.getLinerById(LINER_ID1)).thenReturn(linerDTO);

        mockMvc.perform(
                        get(MOCK_URL + LINER_ID1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(LINER_ID1));

    }

    @Test
    void getAllCruises() throws Exception {
        LinerDTO linerDTO1 = LinerDTO.builder().id(LINER_ID1).name(NAME).deck_amount(DECK_AMOUNT).capacity(CAPACITY).build();
        LinerDTO linerDTO2 = LinerDTO.builder().id(LINER_ID2).name(NAME).deck_amount(DECK_AMOUNT).capacity(CAPACITY).build();
        List<LinerDTO> linerDTOS = List.of(linerDTO1, linerDTO2);

        when(linerService.getAllLiners()).thenReturn(linerDTOS);

        mockMvc.perform(
                        get(MOCK_URL))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(LINER_ID1))
                .andExpect(jsonPath("$[1].id").value(LINER_ID2));
    }

    @Test
    void createLiner() throws Exception {
        LinerDTO linerDTO = LinerDTO.builder().id(LINER_ID1).name(NAME).deck_amount(DECK_AMOUNT).capacity(CAPACITY).build();

        doNothing().when(linerService).saveLiner(linerDTO);

        mockMvc.perform(
                        post(MOCK_URL).contentType("application/json")
                                .content(objectMapper.writeValueAsString(linerDTO)))
                .andDo(print())
                .andExpect(status().isCreated());

        verify(linerService).saveLiner(linerDTO);
    }

    @Test
    void createInvalidLinerName() throws Exception {
        LinerDTO linerDTO = LinerDTO.builder().id(LINER_ID1).name(INVALID_NAME).deck_amount(DECK_AMOUNT).capacity(CAPACITY).build();

        doNothing().when(linerService).saveLiner(linerDTO);

        mockMvc.perform(
                        post(MOCK_URL).contentType("application/json")
                                .content(objectMapper.writeValueAsString(linerDTO)))

                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void createInvalidLinerDeck() throws Exception {
        LinerDTO linerDTO = LinerDTO.builder().id(LINER_ID1).name(NAME).deck_amount(INVALID_DECK_AMOUNT).capacity(CAPACITY).build();

        doNothing().when(linerService).saveLiner(linerDTO);

        mockMvc.perform(
                        post(MOCK_URL).contentType("application/json")
                                .content(objectMapper.writeValueAsString(linerDTO)))

                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void createInvalidLinerCapacity() throws Exception {
        LinerDTO linerDTO = LinerDTO.builder().id(LINER_ID1).name(NAME).deck_amount(DECK_AMOUNT).capacity(INVALID_CAPACITY).build();

        doNothing().when(linerService).saveLiner(linerDTO);

        mockMvc.perform(
                        post(MOCK_URL).contentType("application/json")
                                .content(objectMapper.writeValueAsString(linerDTO)))

                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void updateLiner() throws Exception {
        LinerDTO linerDTO = LinerDTO.builder().id(LINER_ID1).name(NAME).deck_amount(DECK_AMOUNT).capacity(CAPACITY).build();

        doNothing().when(linerService).saveLiner(linerDTO);

        mockMvc.perform(
                        put(MOCK_URL).contentType("application/json")
                                .content(objectMapper.writeValueAsString(linerDTO)))
                .andDo(print())
                .andExpect(status().isOk());

        verify(linerService).saveLiner(linerDTO);
    }

    @Test
    void deleteLiner() throws Exception {
        doNothing().when(linerService).deleteLiner(LINER_ID1);

        mockMvc.perform(
                        delete(MOCK_URL + LINER_ID1))
                .andDo(print())
                .andExpect(status().isOk());

        verify(linerService).deleteLiner(LINER_ID1);
    }
}