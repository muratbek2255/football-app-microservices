package com.example.gametourservice.repository;

import com.example.gametourservice.entity.GameTour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GameTourRepository extends JpaRepository<GameTour, Integer> {

    @Query(value = "SELECT * FROM clubs WHERE clubs.id = ?1", nativeQuery = true)
    GameTour getById(@Param("id") int id);
}
