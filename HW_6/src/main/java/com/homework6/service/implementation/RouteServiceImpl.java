package com.homework6.service.implementation;

import com.homework6.entity.dto.RouteDTO;
import com.homework6.entity.exception.RepositoryException;
import com.homework6.entity.exception.ServiceException;
import com.homework6.mappers.RouteMapper;
import com.homework6.repository.inter.RouteRepository;
import com.homework6.service.inter.RouteService;
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
        try {
            return routeRepository.findAll().stream().map(RouteMapper.INSTANCE::toDTO).collect(Collectors.toList());
        }catch (RepositoryException r){
            log.error("Repository has thrown an exception { }", r);
            throw new ServiceException(r.getMessage());
        }
    }
}
