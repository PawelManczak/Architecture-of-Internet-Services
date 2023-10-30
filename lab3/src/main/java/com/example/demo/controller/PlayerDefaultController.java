package com.example.demo.controller;

import com.example.demo.DTO.GetPlayerResponse;
import com.example.demo.DTO.GetPlayersResponse;
import com.example.demo.DTO.PatchPlayerRequest;
import com.example.demo.DTO.PutPlayerRequest;
import com.example.demo.PlayerService;
import com.example.demo.function.PlayerToResponseFunction;
import com.example.demo.function.PlayersToResponseFunction;
import com.example.demo.function.RequestToPlayerFunction;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log
public class PlayerDefaultController implements PlayerController {

    private final PlayerService service;
    private final PlayerToResponseFunction playerToResponse;
    private final PlayersToResponseFunction playersToResponse;
    private final RequestToPlayerFunction requestToPlayerFunction;


    @Autowired
    public PlayerDefaultController(PlayerService service, PlayersToResponseFunction playersToResponse, PlayerToResponseFunction playerToResponse, RequestToPlayerFunction requestToPlayerFunction) {
        this.service = service;
        this.playersToResponse = playersToResponse;
        this.playerToResponse = playerToResponse;
        this.requestToPlayerFunction = requestToPlayerFunction;
    }

    @Override
    public GetPlayerResponse getPlayer(long id) {
        return playerToResponse.apply(service.findById(id));

    }

    @Override
    public GetPlayersResponse getPlayers() {
        System.out.println(playersToResponse.apply(service.getAll()));
        return playersToResponse.apply(service.getAll());
    }

    @Override
    public void createPlayer(PutPlayerRequest request) {
        service.save(requestToPlayerFunction.apply(request));

    }

    @Override
    public void updatePlayer(long id, PatchPlayerRequest request) {
        //TODO
    }

    @Override
    public void deletePlayer(long id) {
        service.delete(id);
    }
}
