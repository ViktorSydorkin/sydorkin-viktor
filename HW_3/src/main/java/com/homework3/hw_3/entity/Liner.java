package com.homework3.hw_3.entity;

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

    private long id;

    private int capacity;

    private String name;

    private int deck_amount;

    private InputStream liner_photo;

}
