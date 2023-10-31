package com.example.demo;

import com.example.demo.DTO.PatchClubRequest;
import com.example.demo.DTO.PatchPlayerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public Club findByName(String name) {

        try{
            Club club = clubRepository.findByName(name).get(0);
            return club ;
        }catch(Exception e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Club Not Found", e);
        }

    }

    public List<Club> getAll() {
        return clubRepository.findAll().stream().toList();
    }

    public void update(PatchClubRequest newClubData) {
        Club existingClub = clubRepository.findById(newClubData.getId()).orElse(null);


        assert existingClub != null;
        existingClub.setName(newClubData.getClubName());
        existingClub.setStars(newClubData.getStars());
        clubRepository.save(existingClub);
    }

    public void delete(long id){
        clubRepository.deleteById(id);
    }

}