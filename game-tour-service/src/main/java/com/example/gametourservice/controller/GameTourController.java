package com.example.gametourservice.controller;

import com.example.gametourservice.dto.GameTourRequest;
import com.example.gametourservice.dto.GoalScorerRequest;
import com.example.gametourservice.dto.StatisticsRequest;
import com.example.gametourservice.service.GameTourServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class GameTourController {

    private final GameTourServiceImpl gameTourService;

    @Autowired
    public GameTourController(GameTourServiceImpl gameTourService) {
        this.gameTourService = gameTourService;
    }


    @PostMapping("/addGameTour")
    public ResponseEntity<String> addGameTour(@RequestBody GameTourRequest gameTourRequest) {

        return ResponseEntity.status(201).body(gameTourService.addGameTour(gameTourRequest));
    }

    @PutMapping("/addGoalscorer/{id}")
    public ResponseEntity<String> addGoalScorer(@RequestBody GoalScorerRequest goalScorerRequest,
                                                @PathVariable int id, @RequestBody StatisticsRequest statisticsRequest) {

        return ResponseEntity.status(201).body(gameTourService.whoScored(goalScorerRequest, id, statisticsRequest));
    }

    @PutMapping("/addAssistant/{id}")
    public ResponseEntity<String> addAssistant(@RequestBody GoalScorerRequest goalScorerRequest,
                                               @PathVariable int id, @RequestBody StatisticsRequest statisticsRequest) {

        return ResponseEntity.status(201).body(gameTourService.whoAssisted(goalScorerRequest, id, statisticsRequest));
    }
}
