package com.example.clubplayerservice.service;

import com.example.clubplayerservice.dto.request.StatisticsRequest;

public interface StatisticsService {

    public String addGoalForPlayerStatistics(StatisticsRequest statisticsRequest);

    public String addAssistForPlayerStatistics(StatisticsRequest statisticsRequest);
}
