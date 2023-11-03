package com.example.demo.function;

import com.example.demo.Club;
import com.example.demo.ClubService;
import com.example.demo.DTO.PatchPlayerRequest;
import com.example.demo.DTO.PutPlayerRequest;
import com.example.demo.Player;
import com.example.demo.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.function.BiFunction;
import java.util.function.Function;

@Component
public class RequestToPlayerFunction implements Function<PutPlayerRequest, Player> {

    private ClubService clubService;

    @Autowired
    public RequestToPlayerFunction(ClubService service) {
        this.clubService = service;
    }
    @Override
    public Player apply(PutPlayerRequest putPlayerRequest) {
        System.out.println("inside player fun: " + putPlayerRequest.toString());
        Club club = clubService.findByName(putPlayerRequest.getClubName());
        System.out.println(club.toString());

        return Player.builder()
                .name(putPlayerRequest.getName())
                .club(clubService.findByName(putPlayerRequest.getClubName()))
                .overall(putPlayerRequest.getOverall())
                .build();
    }
}
