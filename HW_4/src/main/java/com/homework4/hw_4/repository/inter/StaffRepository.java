package com.homework4.hw_4.repository.inter;

import com.homework4.hw_4.entity.Staff;

import java.util.List;

public interface StaffRepository {

    List<Staff> getAllStaff();

    void addStaff(Staff staff);

    void updateStaff(Staff staff);

    void deleteStaff(long id);

}
