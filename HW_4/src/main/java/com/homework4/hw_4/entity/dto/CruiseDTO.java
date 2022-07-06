package com.homework4.hw_4.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CruiseDTO {

    public long id;

    @NotNull
    @Future
    public Timestamp start;

    @NotNull
    @Future
    public Timestamp end;

    @NotNull
    @Positive
    public int price;

    @NotNull
    @Min(0)
    public int available;

    @NotNull
    public RouteDTO route;

    @NotNull
    public LinerDTO liner;

}