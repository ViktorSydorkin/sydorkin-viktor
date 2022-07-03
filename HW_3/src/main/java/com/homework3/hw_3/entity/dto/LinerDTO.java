package com.homework3.hw_3.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.InputStream;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LinerDTO {

    public long id;

    public int capacity;

    public String name;

    public int deck_amount;

    public InputStream liner_photo;

}
