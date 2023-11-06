package com.learnings.bookmyshow.services;

import com.learnings.bookmyshow.dto.BookingDTO;
import com.learnings.bookmyshow.entities.Booking;
import com.learnings.bookmyshow.entities.Customer;
import com.learnings.bookmyshow.entities.Show;
import com.learnings.bookmyshow.entities.ShowSeat;
import com.learnings.bookmyshow.enums.BookingStatus;
import com.learnings.bookmyshow.enums.SeatStatus;
import com.learnings.bookmyshow.exception.AlreadyBookException;
import com.learnings.bookmyshow.repository.BookingRepository;
import com.learnings.bookmyshow.services.stragery.PriceStrategy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class BookingService {

    private final CustomerService customerService;
    private final BookingRepository bookingRepository;
    private final ShowService showService;
    private final ShowSeatService showSeatService;
    private final PriceStrategy priceStrategy;


    public Booking createBooking(BookingDTO bookingDTO) {
        //validate customer id
        Customer customer = customerService.getCustomerInternal(bookingDTO.getCustomerId());
        if (customer == null) {
            throw new NoSuchElementException("customer with id:" +bookingDTO.getCustomerId()+ " not found");
        }
        //validate show id,
        Show show = showService.getShowInternal(bookingDTO.getShowId());
        if (show == null) {
            throw new NoSuchElementException("show with id:" + bookingDTO.getShowId() + " not found");
        }

        List<ShowSeat> lockSeats = getShowSeats(bookingDTO);

        Booking booking = Booking.builder()
                .show(show)
                .customer(customer)
                .seats(lockSeats)
                .bookingDate(new Date())
                .status(BookingStatus.PENDING)
                .build();
        //calculate price
        Double amount = priceStrategy.calculatePrice(booking);
        Booking withAmount = booking.toBuilder().amount(amount).build();
       return bookingRepository.save(withAmount);
    }

    //Isolation.SERIALIZABLE will enable us to achieve concurrency which helps user to lock seats
    @Transactional(isolation = Isolation.SERIALIZABLE)
    private List<ShowSeat> getShowSeats(BookingDTO bookingDTO) {
        //validate show seats
        List<ShowSeat> showSeats = showSeatService.getAllInternal(bookingDTO.getShowSeatIds());
        //check if they are available or not
        showSeats.forEach(showSeat -> {
            if (showSeat.getSeatStatus() != SeatStatus.AVAILABLE) {
                throw new AlreadyBookException(showSeat.getSeat().getId());
            }
        });
        //if available mark seats LOCKED
        List<ShowSeat> lockSeats =
                showSeats.stream()
                        .map(showSeat -> showSeat.toBuilder().seatStatus(SeatStatus.LOCKED).build()).toList();
        //save seats
        showSeatService.saveAll(lockSeats);
        return lockSeats;
    }
}
