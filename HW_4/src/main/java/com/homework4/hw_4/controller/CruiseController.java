package com.homework4.hw_4.controller;

import com.homework4.hw_4.entity.dto.CruiseDTO;
import com.homework4.hw_4.entity.exception.ControllerException;
import com.homework4.hw_4.entity.exception.ServiceException;
import com.homework4.hw_4.service.inter.CruiseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CruiseController {
    private final CruiseService cruiseService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/cruise/{id}")
    public CruiseDTO getCruiseById(@PathVariable long id) {
        try {
            log.info("Get cruise by id {}", id);
            return cruiseService.getCruiseById(id);
        }catch (ServiceException serviceException){
            throw new ControllerException(serviceException.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/cruise")
    public List<CruiseDTO> getAllCruises() {
        try {
            log.info("Get all cruises");
            return cruiseService.getAllCruise();
        }catch (ServiceException serviceException){
            throw new ControllerException(serviceException.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/cruise")
    public void createCruise(@RequestBody @Valid CruiseDTO cruiseDTO) {
        try {
            log.info("Create cruise {}", cruiseDTO);
            cruiseService.addCruise(cruiseDTO);
        }catch (ServiceException serviceException){
            throw new ControllerException(serviceException.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/cruise/{id}")
    public void changeCruise(@PathVariable long id, @RequestBody String state) {
        try {
            log.info("Change cruise {}", id);
            cruiseService.changeAvailability(id);
        }catch (ServiceException serviceException){
            throw new ControllerException(serviceException.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/cruise")
    public void updateCruise(@RequestBody @Valid CruiseDTO cruiseDTO) {
        try {
            log.info("Update cruise {}", cruiseDTO);
            cruiseService.updateCruise(cruiseDTO);
        }catch (ServiceException serviceException){
            throw new ControllerException(serviceException.getMessage());
        }
    }

    @DeleteMapping("/cruise/{id}")
    public void deleteCruise(@PathVariable long id) {
        try {
            log.info("Delete cruise {}", id);
            cruiseService.deleteCruise(id);
        }catch (ServiceException serviceException){
            throw new ControllerException(serviceException.getMessage());
        }
    }
}
