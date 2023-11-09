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

        clubService.save(newClub);
        clubService.save(newClubB);

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}