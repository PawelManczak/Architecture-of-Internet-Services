package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService {
    private final ClubRepository clubRepository;

    @Autowired
    public ClubService(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    public Club save(Club club) {
        return clubRepository.save(club);
    }

    public Club findById(long clubId) {
        return clubRepository.findById(clubId).orElse(null);
    }

    public List<Club> getAll(){return  clubRepository.findAll().stream().toList();}

}