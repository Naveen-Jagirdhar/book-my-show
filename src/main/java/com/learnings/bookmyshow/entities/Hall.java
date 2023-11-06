package com.learnings.bookmyshow.entities;

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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "HALL")
public class Hall extends Auditable{

    private String name;
    @OneToMany
    private List<Seat> seat = new ArrayList<>();
    @ElementCollection
    @Enumerated
    private List<MovieFeature> features = new ArrayList<>();
}
