package com.example.demo;

import com.example.demo.DTO.PatchPlayerRequest;
import com.example.demo.DTO.PutPlayerRequest;
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

    public Player save(Player player) {
        return playerRepository.save(player);
    }

    public void updatePlayer(PatchPlayerRequest newPlayerData) {
        Player existingPlayer = playerRepository.findById(newPlayerData.getId()).orElse(null);


        if (existingPlayer == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Plyer Not Found");
        }
        Club newClub = clubRepository.findByName(newPlayerData.getClubName()).get(0);

        existingPlayer.setName(newPlayerData.getName());
        existingPlayer.setClub(newClub);
        existingPlayer.setOverall(newPlayerData.getOverall());
        playerRepository.save(existingPlayer);
    }

    public Player findById(long playerId) {
        return playerRepository.findById(playerId).orElse(null);
    }

    public List<Player> findAllFromClub(Club club) {
        return playerRepository.findByClub(club);
    }

    public void delete(long playerId) {
        System.out.println("ASDDASSDADSA " + playerId);
        playerRepository.deleteById(playerId);

    }

    public List<Player> getAll() {
        return playerRepository.findAll();
    }
}