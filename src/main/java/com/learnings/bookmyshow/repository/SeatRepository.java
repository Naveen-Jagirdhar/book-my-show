package com.learnings.bookmyshow.repository;

import com.learnings.bookmyshow.entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat ,Long> {
    List<Seat> findAllByHall_Id(Long id);
}
