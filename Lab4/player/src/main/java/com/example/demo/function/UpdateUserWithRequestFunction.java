package com.example.demo.function;

import com.example.demo.DTO.PutPlayerRequest;
import com.example.demo.entity.Player;

import java.util.function.BiFunction;

public class UpdateUserWithRequestFunction implements BiFunction<Player, PutPlayerRequest, Player> {
    @Override
    public Player apply(Player player, PutPlayerRequest putPlayerRequest) {
        return Player.builder()
                .uuid(player.getUuid())
                .name(player.getName())
                .club(player.getClub())
                .overall(player.getOverall())
                .build();
    }
}
