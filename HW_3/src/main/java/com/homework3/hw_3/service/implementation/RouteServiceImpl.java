package com.homework3.hw_3.service.implementation;



import com.homework3.hw_3.entity.Route;
import com.homework3.hw_3.entity.dto.RouteDTO;
import com.homework3.hw_3.mappers.RouteMapper;
import com.homework3.hw_3.repository.inter.RouteRepository;
import com.homework3.hw_3.service.inter.RouteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
