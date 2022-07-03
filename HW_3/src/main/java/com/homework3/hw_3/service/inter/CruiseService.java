package com.homework3.hw_3.service.inter;


import com.homework3.hw_3.entity.Cruise;
import com.homework3.hw_3.entity.dto.CruiseDTO;

import java.util.List;

public interface CruiseService {
    List<CruiseDTO> getAllCruise(/*long lang_id, int start, int amount*/);

    //int getCruiseAmountDuration(long lang_id, int duration);

    //List<Cruise> listFilterByDuration(int duration, List<Cruise> cruiseList);

    //int getCruiseAmountDate(Timestamp date);

    //List<Cruise> getCruiseByDuration(long lang_id, int start, int amount, int duration);

    //List<Cruise> getCruiseByStartDate(long lang_id, int start, int amount, Timestamp startDate);

    void changeAvailability(long cruise_id);

    void addCruise(CruiseDTO cruiseDTO);

    CruiseDTO getCruiseById(/*long lang_id,*/ long cruise_id);

    void updateCruise(/*long lang_id,*/ CruiseDTO cruiseDTO);


    //List<CruiseTranslation> getAllCruiseTranslations(long cruise_id);

    void deleteCruise(long cruise_id);
}
