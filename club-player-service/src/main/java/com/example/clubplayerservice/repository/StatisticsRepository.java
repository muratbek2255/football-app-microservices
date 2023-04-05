package com.example.clubplayerservice.repository;

import com.example.clubplayerservice.entity.PlayerStatistics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticsRepository extends JpaRepository<PlayerStatistics, Integer> {
}
