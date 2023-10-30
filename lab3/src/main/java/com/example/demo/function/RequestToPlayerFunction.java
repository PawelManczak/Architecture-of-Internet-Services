package com.example.demo.function;

import com.example.demo.DTO.PatchPlayerRequest;
import com.example.demo.DTO.PutPlayerRequest;
import com.example.demo.Player;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;
import java.util.function.Function;

@Component
public class RequestToPlayerFunction implements Function<PutPlayerRequest, Player> {
    @Override
    public Player apply(PutPlayerRequest patchPlayerRequest) {
        return Player.builder()
                .name(patchPlayerRequest.getName())
                .club(patchPlayerRequest.getClub())
                .overall(patchPlayerRequest.getOverall())
                .build();
    }
}
