package com.example.demo.controller;

import com.example.demo.Club;
import com.example.demo.ClubService;
import com.example.demo.DTO.GetClubResponse;
import com.example.demo.DTO.GetClubsResponse;
import com.example.demo.DTO.PatchClubRequest;
import com.example.demo.DTO.PutClubRequest;
import com.example.demo.function.ClubToResponseFunction;
import com.example.demo.function.ClubsToResponseFunction;
import com.example.demo.function.RequestToPlayerFunction;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log
public class ClubDefaultController implements ClubController {

    private final ClubService service;
    private final ClubToResponseFunction clubToResponse;
    private final ClubsToResponseFunction clubsToResponse;
    private final RequestToPlayerFunction requestToPlayerFunction;

    @Autowired
    public ClubDefaultController(ClubService service, ClubsToResponseFunction clubsToResponse, ClubToResponseFunction clubToResponse, RequestToPlayerFunction requestToPlayerFunction) {
        this.service = service;
        this.clubsToResponse = clubsToResponse;
        this.clubToResponse = clubToResponse;
        this.requestToPlayerFunction = requestToPlayerFunction;
    }
    @Override
    public GetClubResponse getClub(long id) {
        return clubToResponse.apply(service.findById(id));
    }

    @Override
    public GetClubsResponse getClubs() {
        return clubsToResponse.apply(service.getAll());
    }

    @Override
    public void createClub(PutClubRequest request) {
        service.save(Club.builder().stars(request.getStars()).name(request.getClubName()).build());
    }

    @Override
    public void updateClub(PatchClubRequest request) {
        service.update(request);
    }


    @Override
    public void deleteClub(long id) {
        service.delete(id);
    }
}
