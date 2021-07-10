package com.linkTracker.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LinkCreatedResponseDTO {
    private String name;
    private String url;
    private String password;
    private String id;
}
