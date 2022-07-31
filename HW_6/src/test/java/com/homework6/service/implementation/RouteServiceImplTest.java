package com.homework6.service.implementation;

import com.homework6.entity.Route;
import com.homework6.repository.inter.RouteRepository;
import com.homework6.repository.inter.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RouteServiceImplTest {
    @Mock
    private RouteRepository routeRepository;

    @InjectMocks
    private RouteServiceImpl routeService;

    private final static long MOCKED_ID1 = 1L;
    private final static long MOCKED_ID2 = 2L;

    @Test
    void getAllRoutes() {
        Route route1 = Route.builder().id(MOCKED_ID1).build();
        Route route2 = Route.builder().id(MOCKED_ID2).build();
        List<Route> routeList = List.of(route1, route2);
        when(routeRepository.findAll()).thenReturn(routeList);

        assertThat(routeService.getAllRoutes(), hasSize(2));
    }
}