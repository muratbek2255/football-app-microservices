package com.example.clubplayerservice.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;


@Entity
@RequiredArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "player_statistics")
public class PlayerStatistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "game")
    Integer game;

    @Column(name = "goal")
    Integer goal;

    @Column(name = "assist")
    Integer assist;

    @Column(name = "yellow_card")
    Integer yellowCard;

    @Column(name = "red_card")
    Integer redCard;

    @Column(name = "kpd")
    Integer kpd;
}
