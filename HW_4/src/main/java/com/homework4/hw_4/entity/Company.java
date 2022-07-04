package com.homework4.hw_4.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    /**
     * Id of the company id DB
     */
    private long id;
    /**
     * Company's title
     */
    private String title;

}
