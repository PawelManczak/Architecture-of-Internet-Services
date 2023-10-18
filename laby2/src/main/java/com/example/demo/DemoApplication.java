package com.example.demo;

import com.sun.tools.javac.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.UUID;

@SpringBootApplication()
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		DataInitializer dataInitializer = context.getBean(DataInitializer.class);
		dataInitializer.initializeSampleData();


		/*List<Club> clubs = clubRepository.findByName("Club A");
		System.out.println("Clubs with name 'Club A':");
		clubs.forEach(System.out::println);/*

		Club clubA = clubs.get(0);
		List<Player> playersInClubA = playerRepository.findByClub(clubA);
		System.out.println("Players in 'Club A':");
		playersInClubA.forEach(System.out::println);

		// 3
		Club newClub = new Club.Builder("Club A")
				.withStars(4)
				.build();
		clubRepository.save(newClub);

		ClubService clubService = context.getBean(ClubService.class);
		clubService.save(newClub);
		long clubId = newClub.getUuid();
		Club retrievedClub = clubService.findById(clubId);
		System.out.println(retrievedClub);*/


		// 4
		SpringApplication.exit(context);
	}

}
