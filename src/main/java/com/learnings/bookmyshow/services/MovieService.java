package com.learnings.bookmyshow.services;

import com.learnings.bookmyshow.entities.Movie;
import com.learnings.bookmyshow.exception.InvalidMovieException;
import com.learnings.bookmyshow.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    public Movie getMovie(Long movieId) {
        return movieRepository.findById(movieId).orElseThrow(() ->
                new InvalidMovieException("Movie with Id:" + movieId +" not found"));
    }

    public Movie createMovie(Movie movie) {

        Optional<Movie> existingMovie = movieRepository.findByName(movie.getName());
        if (existingMovie.isPresent()) {
            throw new InvalidMovieException("Movie with name:"+ movie.getName() + " already exists");
        }
        return movieRepository.save(movie);
    }

    public Movie getMovieInternal(Long movieId) {
        return movieRepository.findById(movieId).orElse(null);
    }
}
