package com.homework4.hw_4.controller;

import com.homework4.hw_4.entity.dto.LinerDTO;
import com.homework4.hw_4.entity.exception.ControllerException;
import com.homework4.hw_4.entity.exception.ServiceException;
import com.homework4.hw_4.service.inter.LinerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LinerController {
    private final LinerService linerService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/liner/{id}")
    public LinerDTO getLinerById(@PathVariable long id) {
        try {
            log.info("get liner by id {}", id);
            return linerService.getLinerById(id);
        } catch (ServiceException serviceException) {
            throw new ControllerException(serviceException.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/liner")
    public List<LinerDTO> getAllCruises() {
        try {
            log.info("Get all liners");
            return linerService.getAllLiners();
        } catch (ServiceException serviceException) {
            throw new ControllerException(serviceException.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/liner")
    public void createLiner(@RequestBody @Valid LinerDTO linerDTO) {
        try {
            log.info("Add liner {}", linerDTO);
            linerService.addLiner(linerDTO);
        } catch (ServiceException serviceException) {
            throw new ControllerException(serviceException.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/liner")
    public void updateLiner(@RequestBody @Valid LinerDTO linerDTO) {
        try {
            log.info("Update liner {}", linerDTO);
            linerService.updateLiner(linerDTO);
        } catch (ServiceException serviceException) {
            throw new ControllerException(serviceException.getMessage());
        }
    }

    @DeleteMapping("/liner/{id}")
    public void deleteLiner(@PathVariable long id) {
        try {
            log.info("Delete liner {}", id);
            linerService.deleteLiner(id);
        } catch (ServiceException serviceException) {
            throw new ControllerException(serviceException.getMessage());
        }
    }
}
