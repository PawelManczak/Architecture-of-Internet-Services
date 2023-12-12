package com.example.demo.function;

import com.example.demo.entity.Club;
import com.example.demo.service.ClubService;
import com.example.demo.DTO.PutPlayerRequest;
import com.example.demo.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RequestToPlayerFunction implements Function<PutPlayerRequest, Player> {

    private final ClubService clubService;

    @Autowired
    public RequestToPlayerFunction(ClubService service) {
        this.clubService = service;
    }
    @Override
    public Player apply(PutPlayerRequest putPlayerRequest) {
        System.out.println("inside player fun: " + putPlayerRequest.toString());
        Club club = clubService.findById(putPlayerRequest.getClubId());
        System.out.println("taki rozmiar " + clubService.getAll().size());
        System.out.println(club.getName());

        return Player.builder()
                .name(putPlayerRequest.getName())
                .club(club)
                .overall(putPlayerRequest.getOverall())
                .build();
    }
}
