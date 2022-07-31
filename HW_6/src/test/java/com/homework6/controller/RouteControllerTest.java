package com.homework6.controller;

import com.homework6.TestConfig;
import com.homework6.entity.dto.RouteDTO;
import com.homework6.service.inter.RouteService;
import org.junit.jupiter.api.Test;
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

@Import(TestConfig.class)
@WebMvcTest(RouteController.class)
class RouteControllerTest {

    @MockBean
    private RouteService routeService;

    @Autowired
    private MockMvc mockMvc;

    private static final long ROUTE_ID1 = 1;
    private static final long ROUTE_ID2 = 2;
    private static final String MOCK_URL = "/route/";
    private static final String START = "Start";
    private static final String END = "End";

    @Test
    void getAllCruises() throws Exception {
        RouteDTO route1 = RouteDTO.builder().id(ROUTE_ID1).start(START).end(END).port_amount(1).build();
        RouteDTO route2 = RouteDTO.builder().id(ROUTE_ID2).start(START).end(END).port_amount(1).build();
        List<RouteDTO> routeDTOList = List.of(route1, route2);

        when(routeService.getAllRoutes()).thenReturn(routeDTOList);

        mockMvc.perform(
                        get(MOCK_URL))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(ROUTE_ID1))
                .andExpect(jsonPath("$[1].id").value(ROUTE_ID2));

    }
}