package com.homework4.hw_4.service.implementation;


import com.homework4.hw_4.entity.dto.RouteDTO;
import com.homework4.hw_4.mappers.RouteMapper;
import com.homework4.hw_4.repository.inter.RouteRepository;
import com.homework4.hw_4.service.inter.RouteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;

    @Override
    public List<RouteDTO> getAllRoutes() {
        log.info("Get all routes");
        return routeRepository.getAllRoutes().stream().map(RouteMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }
}
