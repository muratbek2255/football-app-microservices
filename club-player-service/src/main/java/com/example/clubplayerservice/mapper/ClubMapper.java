package com.example.clubplayerservice.mapper;

import com.example.clubplayerservice.dto.response.ClubResponse;
import com.example.clubplayerservice.entity.Club;

public class ClubMapper {

    public static ClubResponse mapToClubResponse(Club club) {

        ClubResponse clubResponse = new ClubResponse();

        clubResponse.setName(club.getName());
        clubResponse.setRank(club.getRank());

        return clubResponse;
    }
}
