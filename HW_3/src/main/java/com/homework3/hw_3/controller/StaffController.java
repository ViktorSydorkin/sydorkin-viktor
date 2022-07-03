package com.homework3.hw_3.controller;

import com.homework3.hw_3.entity.Liner;
import com.homework3.hw_3.entity.Staff;
import com.homework3.hw_3.entity.dto.StaffDTO;
import com.homework3.hw_3.service.inter.StaffService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController(value = "/cruiseCompany")
@RequiredArgsConstructor
public class StaffController {
    private final StaffService staffService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/staff")
    public List<Staff> getAllStaff() {
        log.info("Get all staff");
        return staffService.getAllStaff();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/staff")
    public void createStaff(@RequestBody StaffDTO staffDTO) {
        log.info("Add staff {}", staffDTO);
        staffService.addStaff(staffDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/staff")
    public void updateStaff(@RequestBody StaffDTO staffDTO) {
        log.info("Update staff {}", staffDTO);
        staffService.updateStaff(staffDTO);
    }

    @DeleteMapping("/staff/{id}")
    public void deleteLiner(@PathVariable long id) {
        log.info("Delete staff {}", id);
        staffService.deleteStaff(id);
    }
}
