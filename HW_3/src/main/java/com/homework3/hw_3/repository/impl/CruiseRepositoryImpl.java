package com.homework3.hw_3.repository.impl;

import com.homework3.hw_3.entity.Cruise;
import com.homework3.hw_3.repository.inter.CruiseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CruiseRepositoryImpl implements CruiseRepository {

    @Override
    public List<Cruise> getAllCruise() {
        return null;
    }

    @Override
    public void changeAvailability(long cruiseId) {
    }

    @Override
    public void addCruise(Cruise cruise) {
    }

    @Override
    public Cruise getCruiseById(long cruiseId) {
        return null;
    }

    @Override
    public void updateCruise(Cruise cruise) {
    }

    @Override
    public void deleteCruise(long cruiseId) {
    }
}
