package com.homework3.hw_3.repository.inter;

import com.homework3.hw_3.entity.Staff;

import java.util.List;

public interface StaffRepository {

    List<Staff> getAllStaff();

    void addStaff(Staff staff);

    void updateStaff(Staff staff);

    void deleteStaff(long id);

}
