package com.homework6.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
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
    @PositiveOrZero
    public int price;

    @NotNull
    @PositiveOrZero
    public int available;

    @NotNull
    public RouteDTO route;

    @NotNull
    public LinerDTO liner;

}