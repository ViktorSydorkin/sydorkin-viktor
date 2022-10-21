package com.homework5.controller;

import com.homework5.entity.dto.StaffDTO;
import com.homework5.entity.exception.ControllerException;
import com.homework5.entity.exception.ServiceException;
import com.homework5.service.inter.StaffService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class StaffController {
    private final StaffService staffService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/staff")
    public List<StaffDTO> getAllStaff() {
        try {
            log.info("Get all staff");
            return staffService.getAllStaff();
        } catch (ServiceException serviceException) {
            throw new ControllerException(serviceException.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/staff")
    public void createStaff(@RequestBody @Valid StaffDTO staffDTO) {
        try {
            log.info("Add staff {}", staffDTO);
            staffService.saveStaff(staffDTO);
        } catch (ServiceException serviceException) {
            throw new ControllerException(serviceException.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/staff")
    public void updateStaff(@RequestBody @Valid StaffDTO staffDTO) {
        try {
            log.info("Update staff {}", staffDTO);
            staffService.saveStaff(staffDTO);
        } catch (ServiceException serviceException) {
            throw new ControllerException(serviceException.getMessage());
        }
    }

    @DeleteMapping("/staff/{id}")
    public void deleteLiner(@PathVariable long id) {
        try {
            log.info("Delete staff {}", id);
            staffService.deleteStaff(id);
        } catch (ServiceException serviceException) {
            throw new ControllerException(serviceException.getMessage());
        }
    }
}
