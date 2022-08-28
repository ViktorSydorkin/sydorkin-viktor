package com.homework3.hw_3.controller;

import com.homework3.hw_3.entity.dto.ApplicationDTO;
import com.homework3.hw_3.service.inter.ApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController(value = "/application")
@RequiredArgsConstructor
public class ApplicationController {
    private final ApplicationService applicationService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ApplicationDTO getApplicationById(@PathVariable long id) {
        log.info("Get application {}", id);
        return applicationService.getApplicationById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<ApplicationDTO> getAllApplications() {
        log.info("Get all applications");
        return applicationService.getAllApplications();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createApplication(@RequestBody ApplicationDTO applicationDTO) {
        log.info("Create application {}", applicationDTO);
        applicationService.addApplication(applicationDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{id}")
    public void changeApplication(@PathVariable long id, @RequestBody String state) {
        log.info("Change application {} {}", id, state);
        applicationService.changeApplication(id, state);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public void updateApplication(@RequestBody ApplicationDTO applicationDTO) {
        log.info("Update application {}", applicationDTO);
        applicationService.updateApplication(applicationDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteApplication(@PathVariable long id) {
        log.info("Delete application {}", id);
        applicationService.deleteApplication(id);
    }
}
