package com.homework3.hw_3.entity.dto;

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
public class ApplicationDTO {

    public long id;

    public InputStream pass_photo;

    public Approved approved;

    public Closed closed;

    public Paid paid;

    public Ended ended;

    public UserDTO user;

    public CruiseDTO cruise;

}
