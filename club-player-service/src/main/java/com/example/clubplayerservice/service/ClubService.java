package com.example.clubplayerservice.service;

import com.example.clubplayerservice.dto.request.ClubRequest;
import com.example.clubplayerservice.dto.response.ClubByRankResponse;
import com.example.clubplayerservice.dto.response.ClubByTrophyNameResponse;
import com.example.clubplayerservice.dto.response.ClubResponse;

import java.util.List;

public interface ClubService {

    public List<ClubResponse> getAllClub();

    public String addClub(ClubRequest clubRequest);

    public String updateClub(int id, ClubRequest clubRequest);

    public String deleteClub(int id);

    public ClubByRankResponse getClubByRank(Integer rank);

    public ClubByTrophyNameResponse getClubByTrophy(String nameOfTrophy);
}
