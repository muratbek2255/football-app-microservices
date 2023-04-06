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

    private ClubRepository clubRepository;

    private PlayerRepository playerRepository;


    @Autowired
    public HistoryServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
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

        List<History> playerProfile = historyRepository.findByPlayerProfile_Club_Name(nameOfClub);

        GetPlayersByHisLastAndNowClubResponse clubResponse = new GetPlayersByHisLastAndNowClubResponse();

        clubResponse.setPlayerProfiles(playerProfile);

        return clubResponse;
    }
}
