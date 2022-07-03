package com.homework3.hw_3.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RouteTranslation {
    /**
     * The language of a route's translation
     *
     * @see Language
     */
    private Language language;
    /**
     * The translated start of the route
     */
    private String start;
    /**
     * The translated end of the route
     */
    private String end;

}
