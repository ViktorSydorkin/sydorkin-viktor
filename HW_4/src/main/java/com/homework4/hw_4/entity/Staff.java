package com.homework4.hw_4.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Staff {

    private long id;

    private String name;

    private String surname;

    private String post;

    private Liner liner;

}
