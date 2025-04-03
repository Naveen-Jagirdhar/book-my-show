package com.learnings.bookmyshow.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@Entity
@Table(name = "CITIES")
public class Cities extends Auditable{

    private String name;


    
    @OneToMany
    private List<Theatre> theatre = new ArrayList<>();
}
