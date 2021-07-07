package com.edad.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter @Setter @AllArgsConstructor
public class DateRequestDTO {
    @NotNull(message = "Enter a month!")
    @Min(value = 1, message = "No month minor of 1 exists")
    @Max(value = 12, message = "month 12 is the last month")
    private int month;
    @NotNull(message = "Enter a day!")
    @Min(value = 1, message = "No day minor of 1 exists")
    @Max(value = 31, message = "No exists this day :)")
    private int day;
    @NotNull(message = "Enter a year")
    @Max(value = 2021, message = "We are in 2021 :)")
    private int year;
}
