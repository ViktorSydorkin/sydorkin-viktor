package com.homework4.hw_4.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    /**
     * Id of the role id DB
     */
    private long id;
    /**
     * Type of the role
     */
    protected String type;

}
