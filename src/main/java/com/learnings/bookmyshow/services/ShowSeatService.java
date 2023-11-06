package com.learnings.bookmyshow.services;

import com.learnings.bookmyshow.entities.ShowSeat;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ShowSeatService {

    private final ShowSeatRepository showSeatRepository;

    public void create(List<ShowSeat> showSeats) {
        showSeatRepository.saveAll(showSeats);
    }

    public List<ShowSeat> getAllInternal(List<Long> showSeatIds) {
        return showSeatRepository.findAllById(showSeatIds);
    }

    public void saveAll(List<ShowSeat> lockSeats) {
        showSeatRepository.saveAll(lockSeats);
    }
}
