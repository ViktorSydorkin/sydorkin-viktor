package com.homework5.controller;

import com.homework5.entity.dto.RouteDTO;
import com.homework5.entity.exception.ControllerException;
import com.homework5.entity.exception.ServiceException;
import com.homework5.service.inter.RouteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class RouteController {
    private final RouteService routeService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/route")
    public List<RouteDTO> getAllCruises() {
        try {
            log.info("Get all routes");
            return routeService.getAllRoutes();
        } catch (ServiceException serviceException) {
            throw new ControllerException(serviceException.getMessage());
        }
    }
}
