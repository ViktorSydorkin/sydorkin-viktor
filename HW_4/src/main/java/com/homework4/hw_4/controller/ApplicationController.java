package com.homework4.hw_4.controller;

import com.homework4.hw_4.entity.dto.ApplicationDTO;
import com.homework4.hw_4.entity.exception.ControllerException;
import com.homework4.hw_4.entity.exception.ServiceException;
import com.homework4.hw_4.service.inter.ApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ApplicationController {
    private final ApplicationService applicationService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/application/{id}")
    public ApplicationDTO getApplicationById(@PathVariable long id) {
        try {
            log.info("Get application {}", id);
            return applicationService.getApplicationById(id);
        }catch (ServiceException serviceException){
            throw new ControllerException(serviceException.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/application")
    public List<ApplicationDTO> getAllApplications() {
        try {
            log.info("Get all applications");
            return applicationService.getAllApplications();
        }catch (ServiceException serviceException){
            throw new ControllerException(serviceException.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/application")
    public void createApplication(@RequestBody @Valid ApplicationDTO applicationDTO) {
        try {
            log.info("Create application {}", applicationDTO);
            applicationService.addApplication(applicationDTO);
        }catch (ServiceException serviceException){
            throw new ControllerException(serviceException.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/application/{id}")
    public void changeApplication(@PathVariable long id, @RequestBody String state) {
        try {
            log.info("Change application {} {}", id, state);
            applicationService.changeApplication(id, state);
        }catch (ServiceException serviceException){
            throw new ControllerException(serviceException.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/application")
    public void updateApplication(@RequestBody @Valid ApplicationDTO applicationDTO) {
        try {
            log.info("Update application {}", applicationDTO);
            applicationService.updateApplication(applicationDTO);
        }catch (ServiceException serviceException){
            throw new ControllerException(serviceException.getMessage());
        }
    }

    @DeleteMapping("/application/{id}")
    public void deleteApplication(@PathVariable long id) {
        try {
            log.info("Delete application {}", id);
            applicationService.deleteApplication(id);
        }catch (ServiceException serviceException){
            throw new ControllerException(serviceException.getMessage());
        }
    }
}
