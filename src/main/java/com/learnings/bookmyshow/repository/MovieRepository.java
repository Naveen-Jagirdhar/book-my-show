package com.learnings.bookmyshow.repository;

import com.learnings.bookmyshow.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MovieRepository extends JpaRepository<Movie ,Long> {
    Optional<Movie> findByName(String name);
}
