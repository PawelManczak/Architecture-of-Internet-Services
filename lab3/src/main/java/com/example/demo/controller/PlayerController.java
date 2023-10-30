package com.example.demo.controller;

import com.example.demo.DTO.GetPlayerResponse;
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

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    void createPlayer(@RequestBody PutPlayerRequest request);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void updatePlayer(@PathVariable("id") long id, @RequestBody PatchPlayerRequest request);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deletePlayer(@PathVariable long id);
}
