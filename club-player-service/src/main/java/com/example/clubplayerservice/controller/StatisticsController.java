package com.example.clubplayerservice.controller;


import com.example.clubplayerservice.dto.request.StatisticsRequest;
import com.example.clubplayerservice.service.StatisticsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    private final StatisticsServiceImpl statisticsService;

    @Autowired
    public StatisticsController(StatisticsServiceImpl statisticsService) {
        this.statisticsService = statisticsService;
    }

    @PostMapping("/addGoal")
    public ResponseEntity<String> addGoalForPlayerStatistics(@Param("name") StatisticsRequest statisticsRequest) {

        return ResponseEntity.status(201).body(statisticsService.addAssistForPlayerStatistics(statisticsRequest));
    }

    @PostMapping("/addAssist")
    public ResponseEntity<String> addAssistForPlayerStatistics(@Param("name") StatisticsRequest statisticsRequest) {

        return ResponseEntity.status(201).body(statisticsService.addAssistForPlayerStatistics(statisticsRequest));
    }
}
