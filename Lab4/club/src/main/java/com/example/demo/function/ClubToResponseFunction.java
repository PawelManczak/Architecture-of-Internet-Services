package com.example.demo.function;

import com.example.demo.entity.Club;
import com.example.demo.DTO.GetClubResponse;
import com.example.demo.entity.Player;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

@Component
public class ClubToResponseFunction implements BiFunction<Club, List<String>, GetClubResponse> {


    @Override
    public GetClubResponse apply(Club club, List<String> stringList) {
        return GetClubResponse.builder().name(club.getName()).stars(club.getStars()).uuid(club.getUuid()).players(stringList).build();
    }
}
