package com.example.clubplayerservice.service;

import com.example.clubplayerservice.dto.request.ClubRequest;
import com.example.clubplayerservice.dto.response.ClubByRankResponse;
import com.example.clubplayerservice.dto.response.ClubByTrophyNameResponse;
import com.example.clubplayerservice.dto.response.ClubResponse;
import com.example.clubplayerservice.entity.Club;
import com.example.clubplayerservice.mapper.ClubMapper;
import com.example.clubplayerservice.repository.ClubRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ClubServiceImpl implements ClubService {


    private final ClubRepository clubRepository;

    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }


    @Override
    public List<ClubResponse> getAllClub() {

        List<Club> clubs = clubRepository.findAll();

        return clubs.stream().map((map) -> ClubMapper.mapToClubResponse(map)).collect(Collectors.toList());
    }

    @Override
    public Club getById(int id) {

        Club club = clubRepository.getById(id);

//        ClubResponse clubResponse = new ClubResponse();
//
//        clubResponse.setId(club.getId());
//        clubResponse.setRank(club.getRank());
//        clubResponse.setName(club.getName());
//
//        return clubResponse;

        return club;
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

    @Override
    public ClubByRankResponse getClubByRank(Integer rank) {

        Club club = clubRepository.findByRank(rank);

        System.out.println(club);
        ClubByRankResponse clubByRankResponse = new ClubByRankResponse();

        clubByRankResponse.setName(club.getName());

        return clubByRankResponse;
    }

    @Override
    public ClubByTrophyNameResponse getClubByTrophy(String nameOfTrophy) {

        Club club = clubRepository.findByTrophy_Name(nameOfTrophy);

        ClubByTrophyNameResponse clubByTrophyNameResponse = new ClubByTrophyNameResponse();

        clubByTrophyNameResponse.setName(club.getTrophy().getName());

        return clubByTrophyNameResponse;
    }

}
