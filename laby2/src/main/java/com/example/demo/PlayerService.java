package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player save(Player player) {
        return playerRepository.save(player);
    }

    public Player findById(long playerId) {
        return playerRepository.findById(playerId).orElse(null);
    }

    public List<Player> findAllFromClub(Club club){ return  playerRepository.findByClub(club);}

    public void delete(long playerId){ playerRepository.deleteById(playerId);}
    public List<Player> getAll(){return playerRepository.findAll();}
}