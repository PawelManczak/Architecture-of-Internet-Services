package com.example.demo.function;

import com.example.demo.DTO.GetPlayerResponse;
import com.example.demo.DTO.GetPlayersResponse;
import com.example.demo.Player;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class PlayersToResponseFunction implements Function<List<Player>, GetPlayersResponse> {

    @Override
    public GetPlayersResponse apply(List<Player> players) {
        return GetPlayersResponse.builder().players(players.stream()
                        .map(player -> GetPlayersResponse.Player.builder()
                                .id(player.getUuid())
                                .name(player.getName())
                                .clubName(player.getClub() != null ? player.getClub().getName() : "")
                                .build())
                        .toList())
                .build();
    }
}
