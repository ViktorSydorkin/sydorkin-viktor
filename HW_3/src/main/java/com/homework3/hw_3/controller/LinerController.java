package com.homework3.hw_3.controller;

import com.homework3.hw_3.entity.Liner;
import com.homework3.hw_3.entity.dto.LinerDTO;
import com.homework3.hw_3.service.inter.LinerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController(value = "/cruiseCompany")
@RequiredArgsConstructor
public class LinerController {
    private final LinerService linerService;
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/liner/{id}")
    public LinerDTO getLinerById(@PathVariable long id) {
        log.info("get liner by id {}", id);
        return linerService.getLinerById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/liner/")
    public List<LinerDTO> getAllCruises() {
        log.info("Get all liners");
        return linerService.getAllLiners();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/liner/")
    public void createLiner(@RequestBody LinerDTO linerDTO) {
        log.info("Add liner {}", linerDTO);
        linerService.addLiner(linerDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/liner/}")
    public void updateLiner(@RequestBody LinerDTO linerDTO) {
        log.info("Update liner {}", linerDTO);
        linerService.updateLiner(linerDTO);
    }

    @DeleteMapping("/liner/{id}")
    public void deleteLiner(@PathVariable long id) {
        log.info("Delete liner {}", id);
        linerService.deleteLiner(id);
    }
}
