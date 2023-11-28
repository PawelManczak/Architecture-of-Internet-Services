package com.example.demo.event.repository;

import com.example.demo.DTO.GetPlayersResponse;
import com.example.demo.DTO.PatchClubRequest;
import com.example.demo.DTO.PutClubRequest;
import com.example.demo.entity.Club;

import java.util.UUID;


public interface ClubEventRepository {

    void delete(long id);

    void update(PatchClubRequest patchClubRequest);
    void create(PutClubRequest putClubRequest);

    GetPlayersResponse getPlayers(Long clubId);
}
