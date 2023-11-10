package com.example.demo.service;

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

    public Club save(Club club) {
        return clubRepository.save(club);
    }

    public Club findById(long clubId) {
        Club club = clubRepository.findById(clubId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        System.out.println("././././ " + club.getName());
        return club;
    }

    public List<Club> getAll() {
        return clubRepository.findAll().stream().toList();
    }

    public void update(PatchClubRequest newClubData) {
        Club existingClub = clubRepository.findById(newClubData.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        existingClub.setName(newClubData.getClubName());
        existingClub.setStars(newClubData.getStars());
        clubRepository.save(existingClub);
    }

    public void delete(long id) {
        clubRepository.deleteById(id);
        clubEventRepository.delete(id);
    }

}