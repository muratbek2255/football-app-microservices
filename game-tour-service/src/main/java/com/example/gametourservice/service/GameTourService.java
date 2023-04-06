package com.example.gametourservice.service;

import com.example.gametourservice.dto.GameTourRequest;
import com.example.gametourservice.dto.GoalScorerRequest;
import com.example.gametourservice.dto.StatisticsRequest;

public interface GameTourService {

    public String addGameTour(GameTourRequest gameTourRequest);

    public String whoScored(GoalScorerRequest goalScorerRequest, int id, StatisticsRequest statisticsRequest);
}
