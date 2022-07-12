package com.homework5.service.implementation;


import com.homework5.entity.dto.RouteDTO;
import com.homework5.mappers.RouteMapper;
import com.homework5.repository.inter.RouteRepository;
import com.homework5.service.inter.RouteService;
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
        return routeRepository.findAll().stream().map(RouteMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }
}
