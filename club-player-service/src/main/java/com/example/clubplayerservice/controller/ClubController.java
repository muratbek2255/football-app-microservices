package com.example.clubplayerservice.controller;


import com.example.clubplayerservice.dto.request.ClubRequest;
import com.example.clubplayerservice.dto.response.ClubByRankResponse;
import com.example.clubplayerservice.dto.response.ClubByTrophyNameResponse;
import com.example.clubplayerservice.dto.response.ClubResponse;
import com.example.clubplayerservice.service.ClubServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/club")
public class ClubController {

    private final ClubServiceImpl clubService;

    @Autowired
    public ClubController(ClubServiceImpl clubService) {
        this.clubService = clubService;
    }

    @GetMapping
    public ResponseEntity<List<ClubResponse>> getAllClub() {

        return ResponseEntity.status(200).body(clubService.getAllClub());
    }

    @PostMapping
    public ResponseEntity<String> addClub(@RequestBody ClubRequest clubRequest) {

        return ResponseEntity.status(201).body(clubService.addClub(clubRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateClub(@PathVariable int id, @RequestBody ClubRequest clubRequest) {

        return ResponseEntity.status(201).body(clubService.updateClub(id, clubRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClub(@PathVariable int id) {

        return ResponseEntity.status(202).body(clubService.deleteClub(id));
    }

    @GetMapping("/by-rank")
    public ResponseEntity<ClubByRankResponse> getClubByRank(@Param("rank") Integer rank) {

        return ResponseEntity.status(200).body(clubService.getClubByRank(rank));
    }

    @GetMapping("/by-trophy")
    public ResponseEntity<ClubByTrophyNameResponse> getClubByTrophy(@Param("nameOfTrophy") String nameOfTrophy) {

        return ResponseEntity.status(200).body(clubService.getClubByTrophy(nameOfTrophy));
    }
}
