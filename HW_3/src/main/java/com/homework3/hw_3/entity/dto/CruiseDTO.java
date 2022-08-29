package com.homework3.hw_3.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CruiseDTO {

    public long id;

    public Timestamp start;

    public Timestamp end;

    public int price;

    public int available;

    public RouteDTO route;

    public LinerDTO liner;

}