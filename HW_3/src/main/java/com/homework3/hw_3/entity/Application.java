package com.homework3.hw_3.entity;

import com.homework3.hw_3.entity.enums.Approved;
import com.homework3.hw_3.entity.enums.Closed;
import com.homework3.hw_3.entity.enums.Ended;
import com.homework3.hw_3.entity.enums.Paid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.InputStream;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Application {

    private long id;

    private InputStream pass_photo;

    private Approved approved;

    private Closed closed;

    private Paid paid;

    private Ended ended;

    private User user;

    private Cruise cruise;

}
