package com.learnings.bookmyshow.services;

import com.learnings.bookmyshow.entities.Hall;
import com.learnings.bookmyshow.repository.HallRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HallService {

    private final HallRepository hallRepository;

    public Hall getHallInternal(Long hallId) {
        return hallRepository.findById(hallId).orElse(null);
    }
}
