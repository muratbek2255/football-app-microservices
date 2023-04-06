package com.example.gametourservice.service;

import com.example.gametourservice.clients.PlayerStatisticsClient;
import com.example.gametourservice.dto.GameTourRequest;
import com.example.gametourservice.dto.GoalScorerRequest;
import com.example.gametourservice.dto.StatisticsRequest;
import com.example.gametourservice.entity.GameTour;
import com.example.gametourservice.repository.GameTourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GameTourServiceImpl implements GameTourService {

    private final GameTourRepository gameTourRepository;

    private final PlayerStatisticsClient playerStatisticsClient;

    @Autowired
    public GameTourServiceImpl(GameTourRepository gameTourRepository, PlayerStatisticsClient playerStatisticsClient) {
        this.gameTourRepository = gameTourRepository;
        this.playerStatisticsClient = playerStatisticsClient;
    }

    @Override
    public String addGameTour(GameTourRequest gameTourRequest) {

        GameTour gameTour = new GameTour();

        gameTour.setFirstTeam(gameTourRequest.getFirstTeam());
        gameTour.setSecondTeam(gameTourRequest.getLastTeam());

        return "Add match";
    }

    @Override
    public String whoScored(GoalScorerRequest goalScorerRequest, int id, StatisticsRequest statisticsRequest) {

        GameTour gameTour = gameTourRepository.getById(id);

        if (goalScorerRequest.isGoal1()) {

            gameTour.setScore1(gameTour.getScore1() + 1);
            gameTour.setGoalscorer1(goalScorerRequest.getGoalscorer1());

            statisticsRequest.setName(goalScorerRequest.getGoalscorer1());

            playerStatisticsClient.addGoalForPlayerStatistics(statisticsRequest);

            return "WUY";
        }
        else {

            gameTour.setScore2(gameTour.getScore2() + 1);
            gameTour.setGoalscorer2(goalScorerRequest.getGoalscorer2());

            statisticsRequest.setName(goalScorerRequest.getGoalscorer2());

            playerStatisticsClient.addGoalForPlayerStatistics(statisticsRequest);

            return "SHUY";
        }
    }
}
