package com.example.clubplayerservice.service;

import com.example.clubplayerservice.dto.ClubRequest;

public interface ClubService {

    public String addClub(ClubRequest clubRequest);

    public String updateClub(int id, ClubRequest clubRequest);

    public String deleteClub(int id);
}
