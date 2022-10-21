package com.homework5.entity;

import com.homework5.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String surname;

    private String email;

    private String password;

    private Role role;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Application> applicationSet;

}
