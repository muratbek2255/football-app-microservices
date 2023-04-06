package com.example.clubplayerservice.mapper;


import com.example.clubplayerservice.dto.response.HistoryResponse;
import com.example.clubplayerservice.entity.History;

public class HistoryMapper {

    public static HistoryResponse mapToHistoryResponse(History history) {

        HistoryResponse historyResponse = new HistoryResponse();

        historyResponse.setClubRequest(history.getClub());
        historyResponse.setPlayerRequest(history.getPlayerProfile());
        historyResponse.setInTeamWith(history.getInTeamWith());
        historyResponse.setUntilWithTeam(history.getUntilWithTeam());

        return historyResponse;
    }
}
