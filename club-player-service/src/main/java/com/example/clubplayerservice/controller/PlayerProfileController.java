package com.example.clubplayerservice.controller;


import com.example.clubplayerservice.dto.request.PlayerRequest;
import com.example.clubplayerservice.service.PlayerProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/player")
public class PlayerProfileController {

    private final PlayerProfileServiceImpl playerProfileService;

    @Autowired
    public PlayerProfileController(PlayerProfileServiceImpl playerProfileService) {
        this.playerProfileService = playerProfileService;
    }

    @PostMapping
    public ResponseEntity<String> addPlayerProfile(@RequestBody PlayerRequest playerRequest) {

        return ResponseEntity.status(201).body(playerProfileService.addPlayerProfile(playerRequest));
    }
}
