package com.learnings.bookmyshow.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@Entity
@Table(name = "THEATRE")
public class Theatre extends Auditable{

    @ManyToOne
    @JoinColumn(name = "city_id")
    private Cities cities;
    private String name;
    private String address;
    @OneToMany
    private List<Hall> screens = new ArrayList<>();
    @OneToMany
    private List<Show> shows = new ArrayList<>();
}
