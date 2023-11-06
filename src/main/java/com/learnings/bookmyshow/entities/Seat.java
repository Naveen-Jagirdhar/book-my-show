package com.learnings.bookmyshow.entities;

import com.learnings.bookmyshow.enums.SeatType;
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
public class Seat extends Auditable{

    private Integer rowNo;
    private Integer columnNo;
    @Enumerated
    private SeatType seatType;
    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;
}
