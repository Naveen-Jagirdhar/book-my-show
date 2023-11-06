package com.learnings.bookmyshow.repository;

import com.learnings.bookmyshow.entities.Hall;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HallRepository extends JpaRepository<Hall, Long> {
}
