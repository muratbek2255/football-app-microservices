package com.example.clubplayerservice.dto.response;


import com.example.clubplayerservice.entity.Club;
import com.example.clubplayerservice.entity.PlayerProfile;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;


@Getter
@Setter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HistoryResponse {


    Club clubRequest;

    PlayerProfile playerRequest;

    Timestamp inTeamWith;

    Timestamp untilWithTeam;
}
