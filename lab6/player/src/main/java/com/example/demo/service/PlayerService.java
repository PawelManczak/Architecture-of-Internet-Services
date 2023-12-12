package com.example.demo.service;

import com.example.demo.entity.Club;
import com.example.demo.repository.ClubRepository;
import com.example.demo.DTO.PatchPlayerRequest;
import com.example.demo.entity.Player;
import com.example.demo.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final ClubRepository clubRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, ClubRepository clubRepository) {
        this.playerRepository = playerRepository;
        this.clubRepository = clubRepository;
    }

    public void save(Player player) {
        playerRepository.save(player);
    }

    public void updatePlayer(Player player) {

        playerRepository.save(player);
    }

    public Player findById(long playerId) {
        return playerRepository.findById(playerId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<Player> findAllFromClub(Club club) {
        return playerRepository.findByClub(club);
    }

    public List<Player> findAllFromClub(Long clubId) {
        return playerRepository.findByClubUuid(clubId);
    }

    public void delete(long playerId) {
        System.out.println("ASDDASSDADSA " + playerId);
        playerRepository.deleteById(playerId);

    }

    public List<Player> getAll() {
        return playerRepository.findAll();
    }
}