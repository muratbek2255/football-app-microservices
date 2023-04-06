package com.example.clubplayerservice.service;


import com.example.clubplayerservice.dto.request.PlayerRequest;
import com.example.clubplayerservice.entity.Club;
import com.example.clubplayerservice.entity.History;
import com.example.clubplayerservice.entity.PlayerProfile;
import com.example.clubplayerservice.repository.HistoryRepository;
import com.example.clubplayerservice.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlayerProfileServiceImpl implements PlayerProfileService {

    private final PlayerRepository playerRepository;

    private final ClubServiceImpl clubService;

    private final HistoryRepository historyRepository;

    @Autowired
    public PlayerProfileServiceImpl(PlayerRepository playerRepository, ClubServiceImpl clubService, HistoryRepository historyRepository) {
        this.playerRepository = playerRepository;
        this.clubService = clubService;
        this.historyRepository = historyRepository;
    }

    @Override
    public String addPlayerProfile(PlayerRequest playerRequest) {

        PlayerProfile playerProfile = new PlayerProfile();

        Club club = clubService.getById(playerRequest.getClub().getId());

        playerProfile.setAvatar(playerRequest.getAvatar());
        playerProfile.setName(playerRequest.getName());
        playerProfile.setSurname(playerRequest.getSurname());
        playerProfile.setAge(playerRequest.getAge());
        playerProfile.setNations(playerRequest.getNations());
        playerProfile.setHeight(playerRequest.getHeight());
        playerProfile.setWeight(playerRequest.getWeight());
        playerProfile.setRole(playerRequest.getRole());
        playerProfile.setKickingLeg(playerRequest.getKickingLeg());
        playerProfile.setClub(club);
        playerProfile.setSocialNetwork(playerRequest.getSocialNetwork());

        if(playerProfile.getName() != null) {
            History history = new History();

            history.setClub(club);
            history.setPlayerProfile(playerProfile);

            historyRepository.save(history);
        }

        playerRepository.save(playerProfile);

        return "Player Profile created!";
    }

    @Override
    public String deletePlayerProfile(int id) {

        playerRepository.deleteById(id);

        return "Delete Player Profile";
    }
}
