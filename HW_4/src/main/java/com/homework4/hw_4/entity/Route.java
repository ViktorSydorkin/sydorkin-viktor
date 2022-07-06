package com.homework4.hw_4.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Route {

    private long id;

    private int port_amount;

    private List<RouteTranslation> routeTranslationList;
}
