package com.homework3.hw_3.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDTO {
    /**
     * Id of the company id DB
     */
    public long id;
    /**
     * Company's title
     */
    public String title;

}
