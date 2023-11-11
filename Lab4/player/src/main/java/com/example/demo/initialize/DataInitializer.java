package com.example.demo.initialize;

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
        Club newClub = Club.builder().uuid(1).name("Club A").stars(4).build();
        Club newClubB = Club.builder().uuid(2).name("Club B").stars(5).build();

        Player newPlayer = Player.builder().uuid(1).name("New Player0").club(newClub).overall(85).build();
        Player newPlayer1 = Player.builder().uuid(2).name("New Player1").club(newClub).overall(80).build();
        Player newPlayer2 = Player.builder().uuid(3).name("New Player2").club(newClub).overall(89).build();
        Player newPlayer3 = Player.builder().uuid(4).name("New Player3").club(newClubB).overall(95).build();

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