package com.homework6.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.homework6.TestConfig;
import com.homework6.entity.dto.CruiseDTO;
import com.homework6.entity.dto.LinerDTO;
import com.homework6.entity.dto.RouteDTO;
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
@WebMvcTest(CruiseController.class)
class CruiseControllerTest {

    @MockBean
    private CruiseService cruiseService;

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
    private static final long CRUISE_ID2 = 2;
    private static final String MOCK_URL = "/cruise/";
    private static final int PRICE = 1;
    private static final int INVALID_PRICE = -1;
    private static final int AVAILABLE = 1;
    private static final int INVALID_AVAILABLE = -1;
    private static final Timestamp START_DATE= Timestamp.valueOf(LocalDateTime.now().plusDays(2).toString().substring(0, 22).replace("T", " "));
    private static final Timestamp INVALID_START_DATE= Timestamp.valueOf(LocalDateTime.now().minusDays(2).toString().substring(0, 22).replace("T", " "));
    private static final Timestamp END_DATE = Timestamp.valueOf(LocalDateTime.now().plusDays(3).toString().substring(0, 22).replace("T", " "));
    private static final Timestamp INVALID_END_DATE = Timestamp.valueOf(LocalDateTime.now().minusDays(3).toString().substring(0, 22).replace("T", " "));
    private static final RouteDTO routeDTO = RouteDTO.builder().id(ROUTE_ID1).start(START).end(END).port_amount(1).build();
    private static final LinerDTO linerDTO = LinerDTO.builder().id(LINER_ID1).name(NAME).deck_amount(DECK_AMOUNT).capacity(CAPACITY).build();



    @Test
    void getCruiseById() throws Exception {
        CruiseDTO cruiseDTO = CruiseDTO.builder().id(CRUISE_ID1).available(AVAILABLE).price(PRICE)
                .start(Timestamp.valueOf(LocalDateTime.now())).end(Timestamp.valueOf(LocalDateTime.now()))
                .route(routeDTO).liner(linerDTO).build();

        when(cruiseService.getCruiseById(CRUISE_ID1)).thenReturn(cruiseDTO);

        mockMvc.perform(
                        get(MOCK_URL + CRUISE_ID1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(CRUISE_ID1));
    }

    @Test
    void getAllCruises() throws Exception {
        CruiseDTO cruiseDTO1 = CruiseDTO.builder().id(CRUISE_ID1).available(AVAILABLE).price(PRICE)
                .start(START_DATE).end(END_DATE)
                .route(routeDTO).liner(linerDTO).build();
        CruiseDTO cruiseDTO2 = CruiseDTO.builder().id(CRUISE_ID2).available(AVAILABLE).price(PRICE)
                .start(START_DATE).end(END_DATE)
                .route(routeDTO).liner(linerDTO).build();
        List<CruiseDTO> cruiseDTOList = List.of(cruiseDTO1, cruiseDTO2);

        when(cruiseService.getAllCruise()).thenReturn(cruiseDTOList);

        mockMvc.perform(
                        get(MOCK_URL))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(CRUISE_ID1))
                .andExpect(jsonPath("$[1].id").value(CRUISE_ID2));
    }

    @Test
    void createCruise() throws Exception {
        CruiseDTO cruiseDTO = CruiseDTO.builder().id(CRUISE_ID1).available(AVAILABLE).price(PRICE)
                .start(START_DATE).end(END_DATE)
                .route(routeDTO).liner(linerDTO).build();

        doNothing().when(cruiseService).saveCruise(cruiseDTO);

        mockMvc.perform(
                        post(MOCK_URL).contentType("application/json")
                                .content(objectMapper.writeValueAsString(cruiseDTO)))
                .andDo(print())
                .andExpect(status().isCreated());
        verify(cruiseService).saveCruise(cruiseDTO);
    }

    @Test
    void createInvalidCruisePrice() throws Exception {
        CruiseDTO cruiseDTO = CruiseDTO.builder().id(CRUISE_ID1).available(AVAILABLE).price(INVALID_PRICE)
                .start(START_DATE).end(END_DATE)
                .route(routeDTO).liner(linerDTO).build();

        doNothing().when(cruiseService).saveCruise(cruiseDTO);

        mockMvc.perform(
                        post(MOCK_URL).contentType("application/json")
                                .content(objectMapper.writeValueAsString(cruiseDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void createInvalidCruiseAvailable() throws Exception {
        CruiseDTO cruiseDTO = CruiseDTO.builder().id(CRUISE_ID1).available(INVALID_AVAILABLE).price(PRICE)
                .start(START_DATE).end(END_DATE)
                .route(routeDTO).liner(linerDTO).build();

        doNothing().when(cruiseService).saveCruise(cruiseDTO);

        mockMvc.perform(
                        post(MOCK_URL).contentType("application/json")
                                .content(objectMapper.writeValueAsString(cruiseDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void createInvalidCruiseStart() throws Exception {
        CruiseDTO cruiseDTO = CruiseDTO.builder().id(CRUISE_ID1).available(AVAILABLE).price(PRICE)
                .start(INVALID_START_DATE).end(END_DATE)
                .route(routeDTO).liner(linerDTO).build();

        doNothing().when(cruiseService).saveCruise(cruiseDTO);

        mockMvc.perform(
                        post(MOCK_URL).contentType("application/json")
                                .content(objectMapper.writeValueAsString(cruiseDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void createInvalidCruiseEnd() throws Exception {
        CruiseDTO cruiseDTO = CruiseDTO.builder().id(CRUISE_ID1).available(AVAILABLE).price(PRICE)
                .start(START_DATE).end(INVALID_END_DATE)
                .route(routeDTO).liner(linerDTO).build();

        doNothing().when(cruiseService).saveCruise(cruiseDTO);

        mockMvc.perform(
                        post(MOCK_URL).contentType("application/json")
                                .content(objectMapper.writeValueAsString(cruiseDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void createInvalidCruiseRoute() throws Exception {
        CruiseDTO cruiseDTO = CruiseDTO.builder().id(CRUISE_ID1).available(AVAILABLE).price(PRICE)
                .start(START_DATE).end(END_DATE)
                .route(null).liner(linerDTO).build();

        doNothing().when(cruiseService).saveCruise(cruiseDTO);

        mockMvc.perform(
                        post(MOCK_URL).contentType("application/json")
                                .content(objectMapper.writeValueAsString(cruiseDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void createInvalidCruiseLiner() throws Exception {
        CruiseDTO cruiseDTO = CruiseDTO.builder().id(CRUISE_ID1).available(AVAILABLE).price(PRICE)
                .start(START_DATE).end(END_DATE)
                .route(routeDTO).liner(null).build();

        doNothing().when(cruiseService).saveCruise(cruiseDTO);

        mockMvc.perform(
                        post(MOCK_URL).contentType("application/json")
                                .content(objectMapper.writeValueAsString(cruiseDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void changeCruise() throws Exception {
        doNothing().when(cruiseService).changeAvailability(CRUISE_ID1);

        mockMvc.perform(
                        patch(MOCK_URL+CRUISE_ID1).contentType("application/json"))
                .andDo(print())
                .andExpect(status().isOk());
        verify(cruiseService).changeAvailability(CRUISE_ID1);

    }

    @Test
    void updateCruise() throws Exception {
        CruiseDTO cruiseDTO = CruiseDTO.builder().id(CRUISE_ID1).available(AVAILABLE).price(PRICE)
                .start(START_DATE).end(END_DATE)
                .route(routeDTO).liner(linerDTO).build();

        doNothing().when(cruiseService).saveCruise(cruiseDTO);

        mockMvc.perform(
                        put(MOCK_URL).contentType("application/json")
                                .content(objectMapper.writeValueAsString(cruiseDTO)))
                .andDo(print())
                .andExpect(status().isOk());

        verify(cruiseService).saveCruise(cruiseDTO);
    }

    @Test
    void deleteCruise() throws Exception {
        doNothing().when(cruiseService).deleteCruise(CRUISE_ID1);

        mockMvc.perform(
                        delete(MOCK_URL + CRUISE_ID1))
                .andDo(print())
                .andExpect(status().isOk());

        verify(cruiseService).deleteCruise(CRUISE_ID1);
    }
}