package com.example.clubplayerservice.repository;

import com.example.clubplayerservice.entity.PlayerStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface StatisticsRepository extends JpaRepository<PlayerStatistics, Integer> {

    PlayerStatistics findByPlayerProfile_Name(@Param("name") String name);
}
