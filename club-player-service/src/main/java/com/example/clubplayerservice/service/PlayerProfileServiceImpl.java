package com.example.clubplayerservice.service;


import com.example.clubplayerservice.dto.request.PlayerRequest;
import com.example.clubplayerservice.repository.HistoryRepository;
import com.example.clubplayerservice.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlayerProfileServiceImpl implements PlayerProfileService {

    private final PlayerRepository playerRepository;

    private ClubServiceImpl clubService;

    private HistoryRepository historyRepository;

    @Autowired
    public PlayerProfileServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public String addPlayerProfile(PlayerRequest playerRequest) {
        return null;
    }

    @Override
    public String deletePlayerProfile(int id) {
        return null;
    }
}
