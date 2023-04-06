package com.example.clubplayerservice.controller;


import com.example.clubplayerservice.dto.request.HistoryRequest;
import com.example.clubplayerservice.dto.response.GetPlayersByHisLastAndNowClubResponse;
import com.example.clubplayerservice.service.HistoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/history")
public class HistoryController {

    private final HistoryServiceImpl historyService;

    @Autowired
    public HistoryController(HistoryServiceImpl historyService) {
        this.historyService = historyService;
    }

    @PostMapping
    public ResponseEntity<String> addHistoryClubAndPlayer(@RequestBody HistoryRequest historyRequest) {

        return ResponseEntity.status(201).body(historyService.addHistoryForPlayerAndClub(historyRequest));
    }

    @GetMapping("/by-club")
    public ResponseEntity<GetPlayersByHisLastAndNowClubResponse> getPlayersByHisLastAndNowClubResponse(
            @Param("nameOfClub") String nameOfClub) {

        return ResponseEntity.status(200).body(historyService.getPlayersByHisClub(nameOfClub));
    }
}
