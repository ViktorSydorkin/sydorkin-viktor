package com.homework4.hw_4.entity.dto;

import com.homework4.hw_4.entity.enums.Approved;
import com.homework4.hw_4.entity.enums.Closed;
import com.homework4.hw_4.entity.enums.Ended;
import com.homework4.hw_4.entity.enums.Paid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
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
    @NotNull
    public UserDTO user;
    @NotNull
    public CruiseDTO cruise;

}
