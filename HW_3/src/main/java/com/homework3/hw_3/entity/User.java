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
    /**
     * Id of user in DB
     */
    private long id;
    /**
     * User's name
     */
    private String name;
    /**
     * User's surname
     */
    private String surname;
    /**
     * User's email address
     */
    private String email;
    /**
     * User's password. In DB - is encrypted
     */
    private String password;
    /**
     * User's role
     *
     * @see Role
     */
    private Role role;
    /**
     * User's preferred language
     *
     * @see Language
     */
    private Language language;

}
