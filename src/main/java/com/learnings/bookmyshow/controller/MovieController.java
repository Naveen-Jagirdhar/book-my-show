package com.learnings.bookmyshow.controller;

import com.learnings.bookmyshow.dto.MovieDTO;
import com.learnings.bookmyshow.services.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/movie")
@AllArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping(path = "/{movieId}")
    public ResponseEntity<?> getMovie(@PathVariable Long movieId){
        return ResponseEntity.ok(movieService.getMovie(movieId));
    }

    @PostMapping
    public ResponseEntity<?> createMovie(@RequestBody MovieDTO movieDTO){
        return ResponseEntity.ok(movieService.createMovie(movieDTO.toMovie()));
    }
}
