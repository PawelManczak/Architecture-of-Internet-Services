package com.example.demo;

import com.example.demo.entity.Club;
import com.example.demo.entity.Player;
import com.example.demo.initialize.DataInitializer;
import com.example.demo.service.ClubService;
import com.example.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {
    @Autowired
    private DataInitializer dataInitializer;
    private PlayerService playerService;
    private ClubService clubService;

    @Autowired
    public ConsoleRunner(ClubService clubService, PlayerService playerService, DataInitializer dataInitializer) {
        this.clubService = clubService;
        this.playerService = playerService;
        this.dataInitializer = dataInitializer;
    }

    @Override
    public void run(String... args) throws Exception {
       // dataInitializer.initializeSampleData();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Available Commands:");
            System.out.println("1. List players");
            System.out.println("2. List clubs");
            System.out.println("3. Add New Player");
            System.out.println("4. Delete Element");
            System.out.println("5. Exit");
            System.out.print("Enter a command (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    playerService.getAll().forEach(System.out::println);
                    break;
                case 2:
                    clubService.getAll().forEach(it -> {System.out.println(it);
                    playerService.findAllFromClub(it).forEach(System.out::println);
                    });
                    break;
                case 3:
                    System.out.print("Enter player's first name and lastname: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter player's overall: ");
                    int overall = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter player's club ID: ");
                    long clubId = scanner.nextLong();
                    scanner.nextLine();
                    Club club = clubService.findById(clubId);
                    Player newPlayer = new Player.Builder(name).withOverall(overall).build();
                    if (club != null) {
                        newPlayer.setClub(club);
                        playerService.save(newPlayer);
                        System.out.println("New player added: " + newPlayer);
                    } else {
                        System.out.println("Club with ID " + clubId + " not found. Player not added.");
                    }
                    break;
                case 4:
                    System.out.print("Enter player's to delete id");
                    long id = scanner.nextLong();

                    Player player = playerService.findById(id);
                    if (player != null) {
                        System.out.println("Player deleted: " + player);
                        playerService.delete(id);
                    } else {
                        System.out.println("Player with ID " + id + " not found. Player not deleted.");
                    }
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
    }

}
