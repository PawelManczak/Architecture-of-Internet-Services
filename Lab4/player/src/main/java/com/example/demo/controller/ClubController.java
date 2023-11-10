package com.example.demo.controller;

import com.example.demo.DTO.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/clubs")
public interface ClubController {
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetClubResponse getClub(@PathVariable("id") long id);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteClub(@PathVariable long id);

}

