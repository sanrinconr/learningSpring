package com.linkTracker.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LinkInvalidatedResponseDTO {
    private String name;
    private String url;
    private String status;
    private String id;
}
