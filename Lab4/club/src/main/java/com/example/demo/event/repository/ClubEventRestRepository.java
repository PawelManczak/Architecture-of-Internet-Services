package com.example.demo.event.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

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

}
