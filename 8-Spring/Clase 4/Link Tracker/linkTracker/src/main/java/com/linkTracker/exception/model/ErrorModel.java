package com.linkTracker.exception.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class ErrorModel {
    private String name;
    private String description;
}
