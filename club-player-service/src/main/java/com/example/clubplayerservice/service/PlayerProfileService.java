package com.example.clubplayerservice.service;

import com.example.clubplayerservice.dto.request.PlayerRequest;

public interface PlayerProfileService {

    public String addPlayerProfile(PlayerRequest playerRequest);

    public String updatePlayerProfile(PlayerRequest playerRequest, int id);

    public String deletePlayerProfile(int id);
}
