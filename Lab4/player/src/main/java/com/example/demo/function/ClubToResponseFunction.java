package com.example.demo.function;

import com.example.demo.Club;
import com.example.demo.DTO.GetClubResponse;
import com.example.demo.Player;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ClubToResponseFunction implements Function<Club, GetClubResponse> {
    @Override
    public GetClubResponse apply(Club club) {
        return GetClubResponse.builder().name(club.getName()).stars(club.getStars()).uuid(club.getUuid()).players(
                club.getPlayers().stream().map(Player::getName).toList()
        ).build();
    }
}
