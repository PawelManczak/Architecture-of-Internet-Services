package com.example.demo.intialize;

import com.example.demo.entity.Club;
import com.example.demo.entity.Player;
import com.example.demo.service.ClubService;
import com.example.demo.service.PlayerService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements InitializingBean {

    private final ClubService clubService;
    private final PlayerService playerService;

    @Autowired
    public DataInitializer(ClubService clubService, PlayerService playerService) {
        this.clubService = clubService;
        this.playerService = playerService;
    }

    public void initializeSampleData() {
        Club newClub = new Club.Builder("Club A").withStars(4).build();
        Club newClubB = new Club.Builder("Club B").withStars(5).build();

        Player newPlayer = new Player.Builder("New Player0").withClub(newClub).withOverall(85).build();
        Player newPlayer1 = new Player.Builder("New Player1").withClub(newClub).withOverall(80).build();
        Player newPlayer2 = new Player.Builder("New Player2").withClub(newClub).withOverall(89).build();
        Player newPlayer3 = new Player.Builder("New Player3").withClub(newClubB).withOverall(95).build();
        clubService.save(newClub);
        clubService.save(newClubB);


        playerService.save(newPlayer);
        playerService.save(newPlayer1);
        playerService.save(newPlayer2);
        playerService.save(newPlayer3);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        initializeSampleData();
    }
}