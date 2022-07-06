package com.homework3.hw_3.controller;

import com.homework3.hw_3.entity.dto.StaffDTO;
import com.homework3.hw_3.service.inter.StaffService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController(value = "/staff")
@RequiredArgsConstructor
public class StaffController {
    private final StaffService staffService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public List<StaffDTO> getAllStaff() {
        log.info("Get all staff");
        return staffService.getAllStaff();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public void createStaff(@RequestBody StaffDTO staffDTO) {
        log.info("Add staff {}", staffDTO);
        staffService.addStaff(staffDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/")
    public void updateStaff(@RequestBody StaffDTO staffDTO) {
        log.info("Update staff {}", staffDTO);
        staffService.updateStaff(staffDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteLiner(@PathVariable long id) {
        log.info("Delete staff {}", id);
        staffService.deleteStaff(id);
    }
}
