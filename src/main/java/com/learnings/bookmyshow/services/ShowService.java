package com.learnings.bookmyshow.services;

import com.learnings.bookmyshow.dto.ShowDTO;
import com.learnings.bookmyshow.entities.Hall;
import com.learnings.bookmyshow.entities.Movie;
import com.learnings.bookmyshow.entities.Seat;
import com.learnings.bookmyshow.entities.Show;
import com.learnings.bookmyshow.entities.ShowSeat;
import com.learnings.bookmyshow.enums.SeatStatus;
import com.learnings.bookmyshow.exception.ShowException;
import com.learnings.bookmyshow.repository.ShowRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ShowService {

    private final ShowRepository showRepository;
    private final HallService hallService;
    private final MovieService movieService;
    private final SeatService seatService;
    private final ShowSeatService showSeatService;

    public Show getShow(Long showId) {
        return showRepository.findById(showId)
                .orElseThrow(() -> new ShowException("show with Id:"+showId+" not found"));
    }

    public Show createShow(ShowDTO showDTO) {

        Hall hall= hallService.getHallInternal(showDTO.getHallId());
        Movie movie = movieService.getMovieInternal(showDTO.getMovieId());

        if (hall== null){
            throw new NoSuchElementException("hall with id:"+ showDTO.getHallId() + " not found");
        }

        if (movie == null) {
            throw new NoSuchElementException("movie with id:" + showDTO.getMovieId() +" not found");
        }

        Show show = Show.builder()
                .hall(hall)
                .movie(movie)
                .duration(showDTO.getDuration())
                .language(showDTO.getLanguage)
                .startTime(showDTO.getStartTime()).build();
        List<Seat> seats = seatService.getAll(hall.getId());
        List<ShowSeat> showSeats = seats.stream().map(
                seat -> ShowSeat.builder()
                        .seat(seat)
                        .show(show)
                        .seatStatus(SeatStatus.AVAILABLE)
                        .build()
        ).toList();
        showSeatService.create(showSeats);
       return showRepository.save(show);
    }

    public Show getShowInternal(Long showId) {
        return showRepository.findById(showId).orElse(null);
    }
}
