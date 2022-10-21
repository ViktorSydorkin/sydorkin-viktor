package com.homework5.entity;

import com.homework5.entity.enums.Approved;
import com.homework5.entity.enums.Closed;
import com.homework5.entity.enums.Ended;
import com.homework5.entity.enums.Paid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.InputStream;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //private InputStream pass_photo;

    private Approved approved;

    private Closed closed;

    private Paid paid;

    private Ended ended;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_cruise_id")
    private Cruise cruise;

}
