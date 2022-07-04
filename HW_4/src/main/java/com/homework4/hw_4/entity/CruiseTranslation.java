package com.homework4.hw_4.entity;

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
