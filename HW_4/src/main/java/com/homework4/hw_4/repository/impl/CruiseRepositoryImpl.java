package com.homework4.hw_4.repository.impl;

import com.homework4.hw_4.entity.Cruise;
import com.homework4.hw_4.repository.inter.CruiseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CruiseRepositoryImpl implements CruiseRepository {

    @Override
    public List<Cruise> getAllCruise() {
        return null;
    }

    @Override
    public void changeAvailability(long cruise_id) {
    }

    @Override
    public void addCruise(Cruise cruise) {
    }

    @Override
    public Cruise getCruiseById(long cruise_id) {
        return null;
    }

    @Override
    public void updateCruise(Cruise cruise) {
    }

    @Override
    public void deleteCruise(long cruise_id) {
    }
}
