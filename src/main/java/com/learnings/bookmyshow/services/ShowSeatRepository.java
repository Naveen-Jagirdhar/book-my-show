package com.learnings.bookmyshow.services;

import com.learnings.bookmyshow.entities.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSeatRepository extends JpaRepository<ShowSeat,Long> {
}
