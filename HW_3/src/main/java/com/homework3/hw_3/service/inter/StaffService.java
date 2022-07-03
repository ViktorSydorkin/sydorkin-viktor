package com.homework3.hw_3.service.inter;

import com.homework3.hw_3.entity.Staff;
import com.homework3.hw_3.entity.dto.StaffDTO;

import java.util.List;

public interface StaffService {
    List<StaffDTO> getAllStaff();

    void addStaff(StaffDTO staffDTO);

    void updateStaff(StaffDTO staffDTO);

    void deleteStaff(long id);
}
