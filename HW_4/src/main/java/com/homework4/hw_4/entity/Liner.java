package com.homework4.hw_4.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.InputStream;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Liner {
    /**
     * Id of the liner id DB
     */
    private long id;
    /**
     * Liner's capacity
     */
    private int capacity;
    /**
     * Liner's name
     */
    private String name;
    /**
     * Amount of liner's daecks
     */
    private int deck_amount;
    /**
     * Photo of the liner
     */
    private InputStream liner_photo;

}
