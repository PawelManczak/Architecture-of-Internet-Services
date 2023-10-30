package com.example.demo.controller;

import com.example.demo.ClubService;
import com.example.demo.DTO.GetClubResponse;
import com.example.demo.DTO.GetClubsResponse;
import com.example.demo.DTO.PatchPlayerRequest;
import com.example.demo.DTO.PutClubRequest;
import com.example.demo.PlayerService;
import com.example.demo.function.ClubToResponseFunction;
import com.example.demo.function.PlayerToResponseFunction;
import com.example.demo.function.PlayersToResponseFunction;
import com.example.demo.function.RequestToPlayerFunction;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log
public class ClubDefaultController implements ClubController {

    private final ClubService service;
    private final ClubToResponseFunction clubToResponse;
    private final PlayersToResponseFunction playersToResponse;
    private final RequestToPlayerFunction requestToPlayerFunction;

    @Autowired
    public ClubDefaultController(ClubService service, PlayersToResponseFunction playersToResponse, ClubToResponseFunction clubToResponse, RequestToPlayerFunction requestToPlayerFunction) {
        this.service = service;
        this.playersToResponse = playersToResponse;
        this.clubToResponse = clubToResponse;
        this.requestToPlayerFunction = requestToPlayerFunction;
    }
    @Override
    public GetClubResponse getClub(long id) {
        System.out.println("klkl " + service.findById(id));
        return clubToResponse.apply(service.findById(id));
    }

    @Override
    public GetClubsResponse getClubs() {
        return null;
    }

    @Override
    public void createClub(PutClubRequest request) {

    }

    @Override
    public void updateClub(PatchPlayerRequest request) {

    }

    @Override
    public void deletePlayer(long id) {

    }
}
