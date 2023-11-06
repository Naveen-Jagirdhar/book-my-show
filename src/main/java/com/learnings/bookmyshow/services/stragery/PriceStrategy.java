package com.learnings.bookmyshow.services.stragery;

import com.learnings.bookmyshow.entities.Booking;

public interface PriceStrategy {

    Double calculatePrice(Booking booking);
}
