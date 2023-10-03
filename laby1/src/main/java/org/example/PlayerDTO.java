package org.example;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class PlayerDTO implements Comparable<PlayerDTO>, Serializable {
    private String name;
    private String clubName;
    private int overall;

    public PlayerDTO(String name, String clubName, int overall) {
        this.name = name;
        this.clubName = clubName;
        this.overall = overall;
    }

    @Override
    public String toString() {
        return "PlayerDTO{" +
                "name='" + name + '\'' +
                ", clubName='" + clubName + '\'' +
                ", overall=" + overall +
                '}';
    }

    @Override
    public int compareTo(PlayerDTO other) {
        return Integer.compare(this.overall, other.overall);
    }
}

