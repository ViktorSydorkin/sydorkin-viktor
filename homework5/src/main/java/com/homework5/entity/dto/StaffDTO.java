package com.homework5.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StaffDTO {

    public long id;

    @NotBlank(message = "'Name' shouldn't be empty!")
    public String name;

    @NotBlank(message = "'Surname' shouldn't be empty!")
    public String surname;

    @NotNull
    @NotBlank
    public String post;

    @NotNull
    @NotBlank
    public LinerDTO liner;

}
