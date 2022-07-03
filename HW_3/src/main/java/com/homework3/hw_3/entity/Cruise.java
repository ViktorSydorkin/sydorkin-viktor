package com.homework3.hw_3.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cruise {
    /**
     * Id of cruise in DB
     */
    private long id;
    /**
     * Time of the cruise's start
     */
    private Timestamp start;
    /**
     * End of the cruise's start
     */
    private Timestamp end;
    /**
     * Cruises price
     */
    private int price;
    /**
     * Amount of available places
     */
    private int available;
    /**
     * Route the cruise is following
     *
     * @see Route
     */
    private Route route;
    /**
     * The cruise's liner
     *
     * @see Liner
     */
    private Liner liner;
    /**
     * The list of cruise's translations
     */
    private List<CruiseTranslation> cruiseTranslationList;

}