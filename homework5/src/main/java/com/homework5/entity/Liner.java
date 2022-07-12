package com.homework5.entity;

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
public class Liner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int capacity;

    private String name;

    private int deck_amount;

    //private InputStream liner_photo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "liner")
    private Set<Staff> staffSet;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_company_id")
    private Company company;
}
