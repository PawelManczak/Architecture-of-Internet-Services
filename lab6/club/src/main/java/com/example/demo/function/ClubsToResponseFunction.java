package com.example.demo.function;

import com.example.demo.entity.Club;
import com.example.demo.DTO.GetClubsResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class ClubsToResponseFunction implements Function<List<Club>, GetClubsResponse> {
    @Override
    public GetClubsResponse apply(List<Club> clubs) {
        return GetClubsResponse.builder().clubs(clubs.stream()
                        .map(club -> GetClubsResponse.Club.builder()
                                .id(club.getUuid())
                                .clubName(club.getName())
                                .build())
                        .toList())
                .build();
    }
}
