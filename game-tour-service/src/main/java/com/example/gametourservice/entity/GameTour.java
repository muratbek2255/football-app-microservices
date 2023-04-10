package com.example.gametourservice.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "game_tours")
public class GameTour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "first_team")
    String firstTeam;

    @Column(name = "second_team")
    String secondTeam;

    @Column(name = "score")
    Integer score1;

    @Column(name = "score_2")
    Integer score2;

    @Column(name = "goalscorer")
    String goalscorer1;

    @Column(name = "assistant")
    String assistant1;

    @Column(name = "goalscorer2")
    String goalscorer2;

    @Column(name = "assistant2")
    String assistant2;
}
