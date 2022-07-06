package com.homework3.hw_3.controller;

import com.homework3.hw_3.entity.dto.RouteDTO;
import com.homework3.hw_3.service.inter.RouteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController(value = "/route")
@RequiredArgsConstructor
public class RouteController {
    private final RouteService routeService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public List<RouteDTO> getAllCruises() {
        log.info("Get all routes");
        return routeService.getAllRoutes();
    }
}
