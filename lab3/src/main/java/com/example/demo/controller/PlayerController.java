package com.example.demo.controller;

import com.example.demo.DTO.GetPlayerResponse;
import com.example.demo.DTO.GetPlayersResponse;
import com.example.demo.DTO.PatchPlayerRequest;
import com.example.demo.DTO.PutPlayerRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/players")
public interface PlayerController {
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetPlayerResponse getPlayer(@PathVariable("id") long id);

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetPlayersResponse getPlayers();

    @PutMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    void createPlayer(@RequestBody PutPlayerRequest request);

    @PatchMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    void updatePlayer(@RequestBody PatchPlayerRequest request);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deletePlayer(@PathVariable long id);
}
