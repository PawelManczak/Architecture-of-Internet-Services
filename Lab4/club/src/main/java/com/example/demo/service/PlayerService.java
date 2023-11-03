package com.example.demo.service;

import com.example.demo.repository.ClubRepository;
import com.example.demo.repository.PlayerRepository;
import com.example.demo.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final ClubRepository clubRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, ClubRepository clubRepository) {
        this.playerRepository = playerRepository;
        this.clubRepository = clubRepository;
    }

    public Player save(Player player) {
        return playerRepository.save(player);
    }


    public Player findById(long playerId) {
        return playerRepository.findById(playerId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void delete(long playerId) {
        System.out.println("ASDDASSDADSA " + playerId);
        playerRepository.deleteById(playerId);

    }

}