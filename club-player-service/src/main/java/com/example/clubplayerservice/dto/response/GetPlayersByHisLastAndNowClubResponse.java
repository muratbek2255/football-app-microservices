package com.example.clubplayerservice.dto.response;


import com.example.clubplayerservice.entity.History;
import com.example.clubplayerservice.entity.PlayerProfile;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;


@Getter
@Setter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetPlayersByHisLastAndNowClubResponse {

    List<History> playerProfiles;
}
