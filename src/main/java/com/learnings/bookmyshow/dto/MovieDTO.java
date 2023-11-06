package com.learnings.bookmyshow.dto;

import com.learnings.bookmyshow.entities.Movie;
import com.learnings.bookmyshow.enums.Language;
import com.learnings.bookmyshow.enums.MovieFeature;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class MovieDTO {

    private String name;
    private Double rating;
    private List<Language> languages = new ArrayList<>();
    private List<MovieFeature> features = new ArrayList<>();

    public Movie toMovie(){
        return Movie.builder()
                .name(name)
                .rating(rating)
                .language(languages)
                .features(features)
                .build();
    }
}
