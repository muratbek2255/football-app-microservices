package com.example.clubplayerservice.repository;

import com.example.clubplayerservice.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface HistoryRepository extends JpaRepository<History, Integer> {

    @Query("select h from History h join h.club c where c.name = :nameOfClub")
    List<History> findByClubName(@Param("nameOfClub") String nameOfClub);
}
