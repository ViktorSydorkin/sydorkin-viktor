package com.homework3.hw_3.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private long id;

    private String name;

    private String surname;

    private String email;

    private String password;

    private Role role;

    private Language language;

}
