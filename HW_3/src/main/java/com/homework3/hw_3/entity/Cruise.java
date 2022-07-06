package com.homework3.hw_3.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cruise {

    private long id;

    private Timestamp start;

    private Timestamp end;

    private int price;

    private int available;

    private Route route;

    private Liner liner;

    private List<CruiseTranslation> cruiseTranslationList;

}