package com.learnings.bookmyshow.dto;

import com.learnings.bookmyshow.entities.ShowSeat;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class BookingDTO {

    private Long customerId;
    private Long showId;
    private List<Long> showSeatIds;
}
