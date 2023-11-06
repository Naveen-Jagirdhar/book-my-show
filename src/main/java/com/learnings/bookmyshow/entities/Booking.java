package com.learnings.bookmyshow.entities;

import com.learnings.bookmyshow.enums.BookingStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Booking extends Auditable{

    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Show show;
    @ManyToMany
    private List<ShowSeat> seats = new ArrayList<>();
    private Double amount;
    private Date bookingDate;
    @Enumerated
    private BookingStatus status;
    @OneToMany
    private List<Payment> payments = new ArrayList<>();
}
