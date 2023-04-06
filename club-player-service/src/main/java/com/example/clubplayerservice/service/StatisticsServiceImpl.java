package com.example.clubplayerservice.service;

import com.example.clubplayerservice.dto.request.StatisticsRequest;
import com.example.clubplayerservice.entity.PlayerStatistics;
import com.example.clubplayerservice.repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StatisticsServiceImpl implements StatisticsService {

    private final StatisticsRepository statisticsRepository;

    @Autowired
    public StatisticsServiceImpl(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }

    @Override
    public String addGoalForPlayerStatistics(StatisticsRequest statisticsRequest) {

        PlayerStatistics playerStatistics = statisticsRepository.findByPlayerProfile_Name(statisticsRequest.getName());
        System.out.println(playerStatistics);

        if(playerStatistics == null) {
            return "Sorry in DB haven't this player";
        }
        else {

            playerStatistics.setGoal(playerStatistics.getGoal() + 1);

            statisticsRepository.save(playerStatistics);

            return playerStatistics.getPlayerProfile().getName() + "Score Goal!";
        }
    }

    @Override
    public String addAssistForPlayerStatistics(StatisticsRequest statisticsRequest) {

        PlayerStatistics playerStatistics = statisticsRepository.findByPlayerProfile_Name(statisticsRequest.getName());

        if(playerStatistics == null) {
            return "Sorry in DB haven't this player";
        }
        else {
            playerStatistics.setGoal(playerStatistics.getAssist() + 1);

            statisticsRepository.save(playerStatistics);

            return playerStatistics.getPlayerProfile().getName() + "Do Assist!";
        }
    }
}
