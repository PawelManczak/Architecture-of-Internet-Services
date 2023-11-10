/*package com.example.demo.controller;

import com.example.demo.DTO.GetPlayerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/players")
public interface PlayerController {
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetPlayerResponse getPlayer(@PathVariable("id") long id);

    // todo idk it should stay here
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deletePlayer(@PathVariable("id") long id);
}
*/