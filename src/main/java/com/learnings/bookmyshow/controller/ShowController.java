package com.learnings.bookmyshow.controller;

import com.learnings.bookmyshow.dto.ShowDTO;
import com.learnings.bookmyshow.services.ShowService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/show")
@AllArgsConstructor
public class ShowController {

    private final ShowService showService;

    @GetMapping("/{showId}")
    public ResponseEntity<?> getShow(@PathVariable Long showId){
        return ResponseEntity.ok(showService.getShow(showId));
    }

    @PostMapping
    public ResponseEntity<?> createShow(@RequestBody ShowDTO showDTO){
        return ResponseEntity.ok(showService.createShow(showDTO));
    }
}
