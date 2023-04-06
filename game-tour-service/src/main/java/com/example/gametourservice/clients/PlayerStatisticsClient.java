package com.example.gametourservice.clients;


import com.example.gametourservice.dto.StatisticsRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "club-player-service", url = "http://localhost:8083")
public interface PlayerStatisticsClient {

    @PostMapping("/statistics/addGoal")
    public ResponseEntity<String> addGoalForPlayerStatistics(@Param("name") StatisticsRequest statisticsRequest);

    @PostMapping("/statistics/addAssist")
    public ResponseEntity<String> addAssistForPlayerStatistics(@Param("name") StatisticsRequest statisticsRequest);
}
