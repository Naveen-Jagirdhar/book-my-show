package com.learnings.bookmyshow.entities;

import com.learnings.bookmyshow.enums.Language;
import com.learnings.bookmyshow.enums.MovieFeature;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "MOVIE")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie extends Auditable{

    private String name;
    private Double rating;
    @ElementCollection
    @Enumerated
    private List<Language> language = new ArrayList<>();
    @ElementCollection
    @Enumerated
    private List<MovieFeature> features = new ArrayList<>();
    @OneToMany(mappedBy = "movie")
    private List<Show> shows = new ArrayList<>();
}
