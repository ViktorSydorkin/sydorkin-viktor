package com.homework5.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.InputStream;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LinerDTO {

    public long id;

    @NotNull
    @Positive
    public int capacity;

    @NotBlank
    public String name;

    @NotNull
    @Positive
    public int deck_amount;

    @NotNull
    public InputStream liner_photo;

}
