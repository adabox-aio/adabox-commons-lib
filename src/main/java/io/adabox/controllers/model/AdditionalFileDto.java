package io.adabox.controllers.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Additional File Dto
 */
@Getter
@Setter
@NoArgsConstructor
public class AdditionalFileDto {

    private String name;
    private String mediaType;
    private String src;
}
