package com.example.demo.controller;

import com.example.demo.DTO.GetPlayerResponse;
import com.example.demo.DTO.GetPlayersResponse;
import com.example.demo.DTO.PatchPlayerRequest;
import com.example.demo.DTO.PutPlayerRequest;
import com.example.demo.entity.Club;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/players")
public interface PlayerController {
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetPlayerResponse getPlayer(@PathVariable("id") long id);

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetPlayersResponse getPlayers();
    @GetMapping("/club/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetPlayersResponse getPlayersFromClub(@PathVariable("id") long id);

    @PutMapping("/")
    @ResponseStatus(HttpStatus.OK)
    void createPlayer(@RequestBody PutPlayerRequest request);

    @PatchMapping("/")
    @ResponseStatus(HttpStatus.OK)
    void updatePlayer(@RequestBody PatchPlayerRequest request);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deletePlayer(@PathVariable("id") long id);
}
