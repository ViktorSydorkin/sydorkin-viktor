package com.homework3.hw_3.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Route {
    /**
     * Id of the route in DB
     */
    private long id;
    /**
     * Amount of the ports along the route
     */
    private int port_amount;
    /**
     * List of route's translation
     *
     * @see RouteTranslation
     */
    private List<RouteTranslation> routeTranslationList;
}
