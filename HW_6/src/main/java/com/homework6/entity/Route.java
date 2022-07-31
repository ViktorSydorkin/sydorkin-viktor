package com.homework6.entity;

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
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int port_amount;

    private String start;

    private String end;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "route")
    private Set<Cruise> cruises;

}
