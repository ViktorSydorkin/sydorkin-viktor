package com.homework6.service.inter;

import com.homework6.entity.dto.StaffDTO;

import java.util.List;

public interface StaffService {

    List<StaffDTO> getAllStaff();

    void saveStaff(StaffDTO staffDTO);

    void deleteStaff(long id);

}
