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
    /**
     * Id of staff in DB
     */
    private long id;
    /**
     * Staff's name
     */
    private String name;
    /**
     * Staff's surname
     */
    private String surname;
    /**
     * Staff's post
     */
    private String post;
    /**
     * Liner the staff works on
     *
     * @see Liner
     */
    private Liner liner;

}
