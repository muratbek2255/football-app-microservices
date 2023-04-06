package com.example.clubplayerservice.dto.request;


import com.example.clubplayerservice.dto.request.ClubRequest;
import com.example.clubplayerservice.entity.Trophy;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlayerRequest {

    Integer id;
    String avatar;

    String name;

    String surname;

    Integer age;

    String nations;

    Integer height;

    Integer weight;

    String role;

    String kickingLeg;

    ClubRequest club;

    String socialNetwork;

    Trophy trophy;
}
