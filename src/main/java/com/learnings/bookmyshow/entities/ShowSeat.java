package com.learnings.bookmyshow.entities;

import com.learnings.bookmyshow.enums.SeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table
public class ShowSeat extends Auditable{

    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;
    @ManyToOne
    private Seat seat;
    @Enumerated
    private SeatStatus seatStatus;
}
