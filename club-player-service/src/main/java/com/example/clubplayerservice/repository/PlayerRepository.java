package com.example.clubplayerservice.repository;

import com.example.clubplayerservice.entity.PlayerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<PlayerProfile, Integer> {
}
