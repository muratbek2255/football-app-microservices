package com.example.clubplayerservice.service;


import com.example.clubplayerservice.dto.request.PlayerRequest;
import com.example.clubplayerservice.entity.Club;
import com.example.clubplayerservice.entity.History;
import com.example.clubplayerservice.entity.PlayerProfile;
import com.example.clubplayerservice.repository.ClubRepository;
import com.example.clubplayerservice.repository.HistoryRepository;
import com.example.clubplayerservice.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlayerProfileServiceImpl implements PlayerProfileService {

    private final PlayerRepository playerRepository;

    private ClubRepository clubRepository;

    private HistoryRepository historyRepository;

    @Autowired
    public PlayerProfileServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public String addPlayerProfile(PlayerRequest playerRequest) {

        PlayerProfile playerProfile = new PlayerProfile();

        Club club = clubRepository.findById(playerRequest.getClub().getId()).get();

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

        PlayerProfile playerProfile1 = playerRepository.findById(playerRequest.getId()).get();

        History history = new History();

        history.setPlayerProfile(playerProfile1);
        history.setClub(club);

        historyRepository.save(history);

        playerRepository.save(playerProfile);

        return "Player Profile created!";
    }

    @Override
    public String updatePlayerProfile(PlayerRequest playerRequest, int id) {

        PlayerProfile playerProfile = playerRepository.findById(id).get();

        Club club = clubRepository.findById(playerRequest.getClub().getId()).get();

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

        playerRepository.save(playerProfile);

        return "Player Profile updated!";
    }

    @Override
    public String deletePlayerProfile(int id) {

        playerRepository.deleteById(id);

        return "Player Profile deleted";
    }
}
