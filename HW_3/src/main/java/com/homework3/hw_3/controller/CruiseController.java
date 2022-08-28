package com.homework3.hw_3.controller;

import com.homework3.hw_3.entity.dto.CruiseDTO;
import com.homework3.hw_3.service.inter.CruiseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController(value = "/cruise/")
@RequiredArgsConstructor
public class CruiseController {
    private final CruiseService cruiseService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public CruiseDTO getCruiseById(@PathVariable long id) {
        log.info("Get cruise by id {}", id);
        return cruiseService.getCruiseById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<CruiseDTO> getAllCruises() {
        log.info("Get all cruises");
        return cruiseService.getAllCruise();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createCruise(@RequestBody CruiseDTO cruiseDTO) {
        log.info("Create cruise {}", cruiseDTO);
        cruiseService.addCruise(cruiseDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{id}")
    public void changeCruise(@PathVariable long id, @RequestBody String state) {
        log.info("Change cruise {}", id);
        cruiseService.changeAvailability(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public void updateCruise(@RequestBody CruiseDTO cruiseDTO) {
        log.info("Update cruise {}", cruiseDTO);
        cruiseService.updateCruise(cruiseDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCruise(@PathVariable long id) {
        log.info("Delete cruise {}", id);
        cruiseService.deleteCruise(id);
    }
}
