package com.learnings.bookmyshow.repository;

import com.learnings.bookmyshow.entities.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show,Long> {
}
