package com.learnings.bookmyshow.services;

import com.learnings.bookmyshow.entities.Seat;
import com.learnings.bookmyshow.repository.SeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SeatService {

    private final SeatRepository seatRepository;

    public List<Seat> getAll(Long id) {
        return seatRepository.findAllByHall_Id(id);
    }
}
