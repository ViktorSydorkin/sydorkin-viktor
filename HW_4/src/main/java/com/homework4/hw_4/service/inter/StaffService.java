package com.homework4.hw_4.service.inter;

import com.homework4.hw_4.entity.dto.StaffDTO;

import java.util.List;

public interface StaffService {

    List<StaffDTO> getAllStaff();

    void addStaff(StaffDTO staffDTO);

    void updateStaff(StaffDTO staffDTO);

    void deleteStaff(long id);

}
