package com.homework4.hw_4.repository.inter;

import com.homework4.hw_4.entity.Cruise;

import java.util.List;

public interface CruiseRepository {
    List<Cruise> getAllCruise(/*long lang_id, int start, int amount*/);

    //int getCruiseAmountDuration(long lang_id, int duration);

    //List<Cruise> listFilterByDuration(int duration, List<Cruise> cruiseList);

    //int getCruiseAmountDate(Timestamp date);

    //List<Cruise> getCruiseByDuration(long lang_id, int start, int amount, int duration);

    //List<Cruise> getCruiseByStartDate(long lang_id, int start, int amount, Timestamp startDate);

    void changeAvailability(long cruise_id);

    void addCruise(Cruise cruise);

    Cruise getCruiseById(/*long lang_id,*/ long cruise_id);

    void updateCruise(/*long lang_id,*/ Cruise cruise);


    //List<CruiseTranslation> getAllCruiseTranslations(long cruise_id);

    void deleteCruise(long cruise_id);

}
