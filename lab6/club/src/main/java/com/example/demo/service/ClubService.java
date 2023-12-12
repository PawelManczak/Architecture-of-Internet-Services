package com.example.demo.service;

import com.example.demo.DTO.GetPlayersResponse;
import com.example.demo.DTO.PutClubRequest;
import com.example.demo.event.repository.ClubEventRepository;
import com.example.demo.repository.ClubRepository;
import com.example.demo.DTO.PatchClubRequest;
import com.example.demo.entity.Club;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClubService {
    private final ClubRepository clubRepository;
    private final ClubEventRepository clubEventRepository;

    @Autowired
    public ClubService(ClubRepository clubRepository, ClubEventRepository clubEventRepository) {
        this.clubRepository = clubRepository;
        this.clubEventRepository = clubEventRepository;
    }

    public void save(Club club) {
        clubRepository.save(club);
        clubEventRepository.create(PutClubRequest.builder().clubName(club.getName()).stars(club.getStars()).build());
    }

    public void saveInitialize(Club club) {
        clubRepository.save(club);
    }
    public Club findById(long clubId) {
        Club club = clubRepository.findById(clubId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return club;
    }
    public List<String> getPlayersName(long clubId){
        return clubEventRepository.getPlayers(clubId).getPlayers().stream().map(GetPlayersResponse.Player::getName).toList();
    }

    public List<Club> getAll() {
        return clubRepository.findAll().stream().toList();
    }

    public void update(PatchClubRequest newClubData) {
        Club existingClub = clubRepository.findById(newClubData.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        existingClub.setName(newClubData.getClubName());
        existingClub.setStars(newClubData.getStars());
        clubRepository.save(existingClub);
        clubEventRepository.update(newClubData);
    }

    public void delete(long id) {
        clubRepository.deleteById(id);
        clubEventRepository.delete(id);
    }

}