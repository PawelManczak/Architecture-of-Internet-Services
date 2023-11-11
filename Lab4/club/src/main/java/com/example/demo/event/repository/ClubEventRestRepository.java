package com.example.demo.event.repository;

import com.example.demo.DTO.GetPlayersResponse;
import com.example.demo.DTO.PatchClubRequest;
import com.example.demo.DTO.PutClubRequest;
import com.example.demo.entity.Club;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

;

@Repository
public class ClubEventRestRepository implements ClubEventRepository {

    /**
     * Configured rest template.
     */
    private final RestTemplate restTemplate;

    @Autowired
    public ClubEventRestRepository(RestTemplate template) {
        this.restTemplate = template;
    }

    @Override
    public void delete(long id) {
        restTemplate.delete("/api/clubs/{id}", id);
    }

    @Override
    public void update(PatchClubRequest patchClubRequest){
        restTemplate.patchForObject("/api/clubs/", patchClubRequest, Void.class);
    }

    @Override
    public void create(PutClubRequest putClubRequest) {
        restTemplate.put("/api/clubs/", putClubRequest);
    }

    @Override
    public GetPlayersResponse getPlayers(Long id) {
        String url = "/api/players/club/{id}";
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        return restTemplate.getForObject(url, GetPlayersResponse.class, id);
    }
}
