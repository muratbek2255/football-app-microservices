package com.example.clubplayerservice.dto.response;


import com.example.clubplayerservice.entity.Club;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClubByRankResponse {

    String name;
}
