package com.linkTracker.dto.response;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("unused")
@Getter @Setter
public class LinkMetricsResponseDTO {
    private String name;
    private String url;
    private String password;
    private String linkID;
    private int timesClicked;
}
