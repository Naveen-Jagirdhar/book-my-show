package com.learnings.bookmyshow.repository;


import com.learnings.bookmyshow.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
