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
@Table(name = "players")
public class PlayerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "avatar")
    String avatar;

    @Column(name = "name")
    String name;

    @Column(name = "surname")
    String surname;

    @Column(name = "age")
    String age;

    @Column(name = "nations")
    String nations;

    @Column(name = "height")
    Integer height;

    @Column(name = "weight")
    Integer weight;

    @Column(name = "role")
    String role;

    @Column(name = "kicking_leg")
    String kickingLeg;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "club_id")
    Club club;

    @Column(name = "social_network")
    String socialNetwork;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "trophy_id")
    Trophy trophy;
}
