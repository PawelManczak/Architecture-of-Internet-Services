package com.example.demo.repository;

import com.example.demo.entity.Club;
import com.example.demo.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByClub(Club club);
    //Player save(Player player);
}
