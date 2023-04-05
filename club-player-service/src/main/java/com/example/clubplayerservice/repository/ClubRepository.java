package com.example.clubplayerservice.repository;

import com.example.clubplayerservice.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClubRepository extends JpaRepository<Club, Integer> {
}
