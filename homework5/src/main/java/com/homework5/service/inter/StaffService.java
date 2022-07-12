package com.homework5.service.inter;

import com.homework5.entity.dto.StaffDTO;

import java.util.List;

public interface StaffService {

    List<StaffDTO> getAllStaff();

    void saveStaff(StaffDTO staffDTO);

    void deleteStaff(long id);

}
