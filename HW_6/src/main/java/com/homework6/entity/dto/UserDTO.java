package com.homework6.entity.dto;

import com.homework6.controller.validation.EmailValidation;
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
public class  UserDTO {

    public long id;

    @NotBlank(message = "'Name' shouldn't be empty!")
    public String name;

    @NotBlank(message = "'Surname' shouldn't be empty!")
    public String surname;

    @EmailValidation
    public String email;

    @NotBlank
    public String password;

    @NotNull
    public String role;

    public String language;

}
