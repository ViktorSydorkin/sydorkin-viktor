package com.homework3.hw_3.repository.inter;

import com.homework3.hw_3.entity.Cruise;

import java.util.List;

public interface CruiseRepository {

    List<Cruise> getAllCruise();

    void changeAvailability(long cruise_id);

    void addCruise(Cruise cruise);

    Cruise getCruiseById(long cruise_id);

    void updateCruise(Cruise cruise);

    void deleteCruise(long cruise_id);

}
