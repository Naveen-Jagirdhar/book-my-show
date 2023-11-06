package com.learnings.bookmyshow.entities;

import com.learnings.bookmyshow.enums.MovieFeature;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Screen extends Auditable{

    private String name;
    private List<Seat> seats = new ArrayList<>();
    private List<MovieFeature> features = new ArrayList<>();
}
