package com.example.demo.controller;

import com.example.demo.DTO.GetPlayerResponse;
import com.example.demo.DTO.GetPlayersResponse;
import com.example.demo.DTO.PatchPlayerRequest;
import com.example.demo.DTO.PutPlayerRequest;
import com.example.demo.entity.Club;
import com.example.demo.function.UpdatePlayerWithRequestFunction;
import com.example.demo.service.PlayerService;
import com.example.demo.function.PlayerToResponseFunction;
import com.example.demo.function.PlayersToResponseFunction;
import com.example.demo.function.RequestToPlayerFunction;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@Log
public class PlayerDefaultController implements PlayerController {

    private final PlayerService service;
    private final PlayerToResponseFunction playerToResponse;
    private final PlayersToResponseFunction playersToResponse;
    private final RequestToPlayerFunction requestToPlayerFunction;

    private final UpdatePlayerWithRequestFunction updatePlayerWithRequestFunction;

    @Autowired
    public PlayerDefaultController(PlayerService service, PlayersToResponseFunction playersToResponse, PlayerToResponseFunction playerToResponse, RequestToPlayerFunction requestToPlayerFunction, UpdatePlayerWithRequestFunction updatePlayerWithRequestFunction) {
        this.service = service;
        this.playersToResponse = playersToResponse;
        this.playerToResponse = playerToResponse;
        this.requestToPlayerFunction = requestToPlayerFunction;
        this.updatePlayerWithRequestFunction = updatePlayerWithRequestFunction;
    }

    @Override
    public GetPlayerResponse getPlayer(long id) {
        return playerToResponse.apply(service.findById(id));
    }

    @Override
    public GetPlayersResponse getPlayers() {
        return playersToResponse.apply(service.getAll());
    }

    @Override
    public GetPlayersResponse getPlayersFromClub(long id) {
        return  playersToResponse.apply(service.findAllFromClub(id));
    }

    @Override
    public void createPlayer(PutPlayerRequest request) {
        System.out.println("cjsad " + request.getClubId());
        service.save(requestToPlayerFunction.apply(request));

    }

    @Override
    public void updatePlayer(PatchPlayerRequest request) {
        service.updatePlayer(updatePlayerWithRequestFunction.apply(request));
    }

    @Override
    public void deletePlayer(long id) {
        service.delete(id);
    }
}
