package com.homework3.hw_3.repository.impl;

import com.homework3.hw_3.entity.Staff;
import com.homework3.hw_3.repository.inter.StaffRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StaffRepositoryImpl implements StaffRepository {
    @Override
    public List<Staff> getAllStaff() {
        return null;
    }

    @Override
    public void addStaff(Staff staff) {
    }

    @Override
    public void updateStaff(Staff staff) {
    }

    @Override
    public void deleteStaff(long staffId) {
    }
}
