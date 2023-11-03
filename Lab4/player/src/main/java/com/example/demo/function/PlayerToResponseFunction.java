package com.example.demo.function;

import com.example.demo.DTO.GetPlayerResponse;
import com.example.demo.Player;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PlayerToResponseFunction implements Function<Player, GetPlayerResponse> {
    @Override
    public GetPlayerResponse apply(Player player) {
        return GetPlayerResponse.builder()
                .uuid(player.getUuid())
                .name(player.getName())
                .clubName(player.getClub().getName())
                .overall(player.getOverall())
                .build();
    }
}
