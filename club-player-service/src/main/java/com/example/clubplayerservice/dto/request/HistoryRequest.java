package com.example.clubplayerservice.dto.request;


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
public class HistoryRequest {

    ClubRequest clubRequest;

    PlayerRequest playerRequest;

    Timestamp inTeamWith;

    Timestamp untilWithTeam;

}
