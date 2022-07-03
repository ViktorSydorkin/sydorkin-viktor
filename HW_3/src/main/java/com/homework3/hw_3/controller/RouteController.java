package com.homework3.hw_3.controller;

import com.homework3.hw_3.entity.Cruise;
import com.homework3.hw_3.entity.Route;
import com.homework3.hw_3.service.inter.RouteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController(value = "/cruiseCompany")
@RequiredArgsConstructor
public class RouteController {
    private final RouteService routeService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/cruiuse/")
    public List<Route> getAllCruises() {
        log.info("Get all routes");
        return routeService.getAllRoutes();
    }
}
