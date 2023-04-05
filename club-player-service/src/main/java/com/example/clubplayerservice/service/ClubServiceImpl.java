package com.example.clubplayerservice.service;

import com.example.clubplayerservice.dto.ClubRequest;
import com.example.clubplayerservice.entity.Club;
import com.example.clubplayerservice.repository.ClubRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClubServiceImpl implements ClubService{


    private final ClubRepository clubRepository;

    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public String addClub(ClubRequest clubRequest) {
        Club club = new Club();

        club.setRank(clubRequest.getRank());
        club.setName(clubRequest.getName());

        clubRepository.save(club);

        return "add club";
    }

    @Override
    public String updateClub(int id, ClubRequest clubRequest) {

        Club club = clubRepository.findById(id).get();

        club.setRank(clubRequest.getRank());

        clubRepository.save(club);

        return "update club";
    }

    @Override
    public String deleteClub(int id) {

        clubRepository.deleteById(id);

        return "Delete club";
    }
}
