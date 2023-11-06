package com.learnings.bookmyshow.services.stragery;

import com.learnings.bookmyshow.entities.Booking;
import com.learnings.bookmyshow.enums.SeatType;
import org.springframework.stereotype.Component;

@Component("seatBasedPricingStrategy")
public class SeatBasedPricingStrategy implements PriceStrategy{
    @Override
    public Double calculatePrice(Booking booking) {
        return booking.getShow().getShowSeat().stream()
                .mapToDouble(value -> getPrice(value.getSeat().getSeatType())).sum();
    }

    // to avoid ocp violations we can move pricing to db
    private static double getPrice(SeatType seatType) {
        switch (seatType){
            case VIP -> {
                return 2000.0;
            }
            case PLATINUM -> {
                return 1500.0;
            }
            case DIAMOND -> {
                return 1000.0;
            }
            case GOLD -> {
                return 500.0;
            }
            case SILVER -> {
                return 250.0;
            }
        }
        throw new IllegalArgumentException("invalid seat type received");
    }
}
