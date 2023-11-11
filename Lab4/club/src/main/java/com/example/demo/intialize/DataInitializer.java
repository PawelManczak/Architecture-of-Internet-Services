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

    @Autowired
    public DataInitializer(ClubService clubService, PlayerService playerService) {
        this.clubService = clubService;
    }

    public void initializeSampleData() {
        Club newClub = Club.builder().uuid(1).name("Club A").stars(4).build();
        Club newClubB = Club.builder().uuid(2).name("Club B").stars(5).build();

        clubService.saveInitialize(newClub);
        clubService.saveInitialize(newClubB);

    }

    @Override
    public void afterPropertiesSet() throws Exception {
       initializeSampleData();
    }
}