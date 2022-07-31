package com.homework6.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RouteDTO {

    public long id;

    @NotNull
    @Positive
    public int port_amount;

    @NotBlank
    public String start;

    @NotBlank
    public String end;
}
