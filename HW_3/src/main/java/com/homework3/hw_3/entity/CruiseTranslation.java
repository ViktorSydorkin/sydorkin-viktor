package com.homework3.hw_3.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CruiseTranslation {
    /**
     * The language of cruise's translations
     *
     * @see Language
     */
    Language language;
    /**
     * The translated cruise's title
     */
    String title;

}
