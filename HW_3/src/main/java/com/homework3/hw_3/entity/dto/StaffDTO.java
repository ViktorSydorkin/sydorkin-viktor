package com.homework3.hw_3.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StaffDTO {

    public long id;

    public String name;

    public String surname;

    public String post;

    public LinerDTO liner;

}
