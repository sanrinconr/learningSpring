package com.diploma.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter @Setter
public class StudentAssignsDTO {
    @NotNull(message = "Student name must be not null")
    private String name;
    @NotNull(message = "The studen must be have assigns")
    @Valid
    private List<AssignRequestDTO> assignRequestDTOList;
}
