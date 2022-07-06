package com.homework4.hw_4.service.inter;

import com.homework4.hw_4.entity.dto.CruiseDTO;

import java.util.List;

public interface CruiseService {

    List<CruiseDTO> getAllCruise();

    void changeAvailability(long cruise_id);

    void addCruise(CruiseDTO cruiseDTO);

    CruiseDTO getCruiseById(long cruise_id);

    void updateCruise(CruiseDTO cruiseDTO);

    void deleteCruise(long cruise_id);

}
