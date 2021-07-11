package com.linkTracker.dto.response;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("unused")
@Getter @Setter
public class LinkIncrementedCounterResponseDTO {
    private String name;
    private String url;
    private String linkID;
    private String timesClicked;
}
