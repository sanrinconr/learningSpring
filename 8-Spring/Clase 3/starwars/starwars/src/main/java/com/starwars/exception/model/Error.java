package com.starwars.exception.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor
public class Error {
    private String name;
    private String description;
}
