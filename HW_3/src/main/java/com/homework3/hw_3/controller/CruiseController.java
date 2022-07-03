package com.homework3.hw_3.controller;

import com.homework3.hw_3.entity.Application;
import com.homework3.hw_3.entity.Cruise;
import com.homework3.hw_3.entity.User;
import com.homework3.hw_3.entity.dto.CruiseDTO;
import com.homework3.hw_3.service.inter.CruiseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController(value = "/cruiseCompany")
@RequiredArgsConstructor
public class CruiseController {
    private final CruiseService cruiseService;
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/cruise/{id}")
    public CruiseDTO getCruiseById(@PathVariable long id) {
        log.info("Get cruise by id {}", id);
        return cruiseService.getCruiseById( id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/cruiuse/")
    public List<CruiseDTO> getAllCruises() {
        log.info("Get all cruises");
        return cruiseService.getAllCruise();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/application/")
    public void createCruise(@RequestBody CruiseDTO cruiseDTO) {
        log.info("Create cruise {}", cruiseDTO);
        cruiseService.addCruise(cruiseDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/application/{id}")
    public void changeCruise(@PathVariable long id, @RequestBody String state){
        log.info("Change cruise {}", id);
        cruiseService.changeAvailability(id);
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/application/}")
    public void updateCruise(@RequestBody CruiseDTO cruiseDTO) {
        log.info("Update cruise {}", cruiseDTO);
        cruiseService.updateCruise(cruiseDTO);
    }

    @DeleteMapping("/application/{id}")
    public void deleteCruise(@PathVariable long id) {
        log.info("Delete cruise {}", id);
        cruiseService.deleteCruise(id);
    }
}
