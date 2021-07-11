package com.linkTracker.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter @Setter @NoArgsConstructor
public class LinkCreateRequestDTO {
    @NotNull(message = "No name passed")
    @NotBlank(message = "Name can't be blank")
    private String name;
    @NotBlank(message = "Url can't be blank")
    @NotNull(message = "No url passed")
    private String url;
    private String password;

    @SuppressWarnings("unused")
    public LinkCreateRequestDTO(String name, String url) {
        this.name = name;
        this.url = url;
        this.password = null;
    }
}
