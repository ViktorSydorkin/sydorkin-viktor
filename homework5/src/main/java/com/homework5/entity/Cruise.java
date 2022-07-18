package com.homework5.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cruise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private Timestamp start;

    private Timestamp end;

    private int price;

    private int available;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_route_id")
    private Route route;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_liner_id")
    private Liner liner;

}