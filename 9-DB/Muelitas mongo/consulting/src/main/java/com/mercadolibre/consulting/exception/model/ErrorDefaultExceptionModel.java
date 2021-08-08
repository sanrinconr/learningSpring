package com.mercadolibre.consulting.exception.model;

import lombok.*;

@Getter
@AllArgsConstructor
public class ErrorDefaultExceptionModel {
    private final String name;
    private final String description;

}
