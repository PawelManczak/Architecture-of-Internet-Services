package com.example.demo.controller;

import com.example.demo.DTO.GetClubResponse;
import com.example.demo.function.ClubToResponseFunction;
import com.example.demo.service.ClubService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log
public class ClubDefaultController implements ClubController {

    private final ClubService service;
    private final ClubToResponseFunction clubToResponse;

    @Autowired
    public ClubDefaultController(ClubService service, ClubToResponseFunction clubToResponse) {
        this.service = service;
        this.clubToResponse = clubToResponse;
    }
    @Override
    public GetClubResponse getClub(long id) {
        return clubToResponse.apply(service.findById(id));
    }

    @Override
    public void deleteClub(long id) {
        service.delete(id);
    }
}
