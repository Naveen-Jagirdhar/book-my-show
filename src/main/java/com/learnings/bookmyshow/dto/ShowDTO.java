package com.learnings.bookmyshow.dto;

import com.learnings.bookmyshow.enums.Language;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class ShowDTO {

    public Language getLanguage;
    private Long hallId;
    private Long movieId;
    private Integer duration;
    private Date startTime;
}
