package com.example.clubplayerservice.repository;

import com.example.clubplayerservice.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface HistoryRepository extends JpaRepository<History, Integer> {

    List<History> findByPlayerProfile_Club_Name(@Param("nameOfClub") String nameOfClub);
}
