package com.example.clubplayerservice.repository;

import com.example.clubplayerservice.entity.ClubAndPlayerHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<ClubAndPlayerHistory, Integer> {
}
