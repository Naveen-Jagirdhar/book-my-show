package com.learnings.bookmyshow.entities;

import com.learnings.bookmyshow.enums.Language;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table
public class Show extends Auditable{

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    private Date startTime;
    private Integer duration;
    @Enumerated
    private Language language;
    @ManyToOne
    private Hall hall;
    @OneToMany(mappedBy = "show")
    private List<ShowSeat> showSeat = new ArrayList<>();

}
