package com.example.clubplayerservice.service;


import com.example.clubplayerservice.dto.request.HistoryRequest;
import com.example.clubplayerservice.dto.response.GetPlayersByHisLastAndNowClubResponse;


public interface HistoryService {

    public String addHistoryForPlayerAndClub(HistoryRequest historyRequest);

    public GetPlayersByHisLastAndNowClubResponse getPlayersByHisClub(String nameOfClub);
}
