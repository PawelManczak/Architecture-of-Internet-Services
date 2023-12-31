package org.example;

import javax.lang.model.element.Element;
import java.io.*;
import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // stream tests

        // filter
        // 1. to stream()
        // 2. business logic
        // 3. to list
        List<String> letters = Arrays.asList("a", "aa", "b", "c", "cc", "dd", "e");
        List<String> filtered = letters.stream().filter(s -> s.length() > 1).toList();
        System.out.println(filtered);
        // ------------


        Club club1 = new Club.Builder("Club A").withStars(5).build();

        Club club2 = new Club.Builder("Club B").withStars(4).build();
        Player player1 = new Player.Builder("Player 1").withClub(club1).withOverall(85).build();

        Player player2 = new Player.Builder("Player 2").withClub(club1).withOverall(90).build();

        Player player3 = new Player.Builder("Player 3").withClub(club2).withOverall(88).build();
        Player player4 = new Player.Builder("Player 4").withClub(club2).withOverall(94).build();
        Player player5 = new Player.Builder("Player 5").withClub(club2).withOverall(93).build();

        ArrayList<Player> list = new ArrayList<Player>();
        list.add(player1);
        list.add(player2);
        list.add(player3);
        list.add(player4);
        list.add(player5);

        club1.setPlayers(list);
        club2.setPlayers(list);
        List<Club> clubs = Arrays.asList(club1, club2);

        for (Club club : clubs) {
            System.out.println(club);
            club.getPlayers().forEach(System.out::println);
        }

        // 3
        System.out.println("===== SET");

        //flatmap flatten stream of streams to one dimension
        Set<Player> allPlayers = clubs.stream().flatMap(club -> club.getPlayers().stream()).collect(Collectors.toSet());

        allPlayers.forEach(System.out::println);

        // 4
        System.out.println("===== FILTERED AND SORTED");

        List<Player> filteredAndSortedPlayers = allPlayers.stream().filter(player -> player.getOverall() > 90).sorted() // Comparator.comparing(Player::getOverall)
                .toList();

        filteredAndSortedPlayers.forEach(System.out::println);

        // 5
        System.out.println("===== sortedPlayerDTOs");
        List<PlayerDTO> sortedPlayerDTOs = allPlayers.stream().map(s -> new PlayerDTO(s.getName(), s.getClub().getName(), s.getOverall())).sorted().toList();

        sortedPlayerDTOs.forEach(System.out::println);

        // 6
        FileOutputStream fileOutputStream = new FileOutputStream("yourfile.txt");
        FileInputStream fileInputStream = new FileInputStream("yourfile.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        try {
            objectOutputStream.writeObject(list); //close stream

        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            objectOutputStream.flush();
            objectOutputStream.close();
        }


        try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            List<Player> p2 = (List<Player>) objectInputStream.readObject();
            System.out.println(p2);
        } catch (Exception e) {
            e.getStackTrace();
        }
        //7
        int[] poolSizes = {1, 2, 4, 8};

        for (int poolSize : poolSizes) {
            System.out.println("Custom pool size: " + poolSize);

            ThreadPoolExecutor executor =
                    (ThreadPoolExecutor) Executors.newFixedThreadPool(poolSize);

            executor.submit(() -> {
                sortedPlayerDTOs.parallelStream().forEach(category -> {
                    try {
                        System.out.println("Processing category: " + category.getName());
                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });

            });

        }
    }
}




