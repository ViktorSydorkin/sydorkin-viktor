package com.homework5.service.inter;

import com.homework5.entity.dto.CruiseDTO;

import java.util.List;

public interface CruiseService {

    List<CruiseDTO> getAllCruise();

    void changeAvailability(long cruise_id);

    void saveCruise(CruiseDTO cruiseDTO);

    CruiseDTO getCruiseById(long cruise_id);

    void deleteCruise(long cruise_id);

}
