package com.example.demo.function;

import com.example.demo.DTO.PatchPlayerRequest;
import com.example.demo.DTO.PutPlayerRequest;
import com.example.demo.entity.Player;
import com.example.demo.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;
import java.util.function.Function;

@Component
public class UpdatePlayerWithRequestFunction implements Function<PatchPlayerRequest, Player> {
    private ClubService clubService;

    @Autowired
    public void RequestToPlayerFunction(ClubService service) {
        this.clubService = service;
    }
    @Override
    public Player apply(PatchPlayerRequest playerRequest) {
        return Player.builder()
                .uuid(playerRequest.getId())
                .name(playerRequest.getName())
                .club(clubService.findById(playerRequest.getClubId()))
                .overall(playerRequest.getOverall())
                .build();
    }
}
