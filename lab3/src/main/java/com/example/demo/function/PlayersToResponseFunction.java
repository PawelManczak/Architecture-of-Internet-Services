package com.example.demo.function;

import com.example.demo.DTO.GetPlayerResponse;
import com.example.demo.DTO.GetPlayersResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class PlayersToResponseFunction implements Function<List<GetPlayersResponse.Player>, GetPlayersResponse> {
    @Override
    public GetPlayersResponse apply(List<GetPlayersResponse.Player> players) {
        return GetPlayersResponse.builder().players(players.stream().
                map(player -> GetPlayersResponse.Player.builder()
                        .id(player.getId())
                        .name(player.getName())
                        .clubName(player.getClubName()).build())
                .toList())
                .build();
    }
}
