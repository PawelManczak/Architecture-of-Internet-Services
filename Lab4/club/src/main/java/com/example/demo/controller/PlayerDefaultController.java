package com.example.demo.controller;

import com.example.demo.DTO.GetPlayerResponse;
import com.example.demo.function.PlayerToResponseFunction;
import com.example.demo.service.PlayerService;
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


    @Autowired
    public PlayerDefaultController(PlayerService service, PlayerToResponseFunction playerToResponse) {
        this.service = service;
        this.playerToResponse = playerToResponse;
    }

    @Override
    public GetPlayerResponse getPlayer(long id) {
        try {
            return playerToResponse.apply(service.findById(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found", e);
        }
    }


    @Override
    public void deletePlayer(long id) {
        service.delete(id);
    }
}
