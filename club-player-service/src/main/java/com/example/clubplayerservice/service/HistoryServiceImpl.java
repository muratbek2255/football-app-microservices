package com.example.clubplayerservice.service;


import com.example.clubplayerservice.dto.request.HistoryRequest;
import com.example.clubplayerservice.dto.response.GetPlayersByHisLastAndNowClubResponse;
import com.example.clubplayerservice.entity.Club;
import com.example.clubplayerservice.entity.History;
import com.example.clubplayerservice.entity.PlayerProfile;
import com.example.clubplayerservice.repository.ClubRepository;
import com.example.clubplayerservice.repository.HistoryRepository;
import com.example.clubplayerservice.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HistoryServiceImpl implements HistoryService {

    private final HistoryRepository historyRepository;

    private final ClubRepository clubRepository;

    private final PlayerRepository playerRepository;


    @Autowired
    public HistoryServiceImpl(HistoryRepository historyRepository, ClubRepository clubRepository, PlayerRepository playerRepository) {
        this.historyRepository = historyRepository;
        this.clubRepository = clubRepository;
        this.playerRepository = playerRepository;
    }

    @Override
    public String addHistoryForPlayerAndClub(HistoryRequest historyRequest) {

        History history = new History();

        Club club = clubRepository.findById(historyRequest.getClubRequest().getId()).get();
        PlayerProfile playerProfile = playerRepository.findById(historyRequest.getPlayerRequest().getId()).get();

        history.setClub(club);
        history.setPlayerProfile(playerProfile);
        history.setInTeamWith(historyRequest.getInTeamWith());
        history.setUntilWithTeam(historyRequest.getUntilWithTeam());

        historyRepository.save(history);

        return "Add history";
    }

    @Override
    public GetPlayersByHisLastAndNowClubResponse getPlayersByHisClub(String nameOfClub) {

        List<History> playerProfile = historyRepository.findByClubName(nameOfClub);
        System.out.println(playerProfile);

        GetPlayersByHisLastAndNowClubResponse clubResponse = new GetPlayersByHisLastAndNowClubResponse();

        clubResponse.setPlayerProfiles(playerProfile);

        return clubResponse;
    }
}
