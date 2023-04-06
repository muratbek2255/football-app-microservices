package com.example.clubplayerservice.repository;

import com.example.clubplayerservice.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


public interface ClubRepository extends JpaRepository<Club, Integer> {

    Club findByRank(@Param("rank") Integer rank);

    Club findByTrophy_Name(@Param("nameofTrophy") String nameOfTrophy);
}
