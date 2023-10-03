package org.example;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.*;

@Getter
public class Player implements Comparable<Player>, Serializable {
    private String name;
    @Setter
    private Club club;
    private int overall;

    private Player(Builder builder) {
        this.name = builder.name;
        this.club = builder.club;
        this.overall = builder.overall;
    }

    @Override
    public int compareTo(Player other) {
        return Integer.compare(this.overall, other.overall);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, club, overall);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Player)) return false;
        Player other = (Player) obj;
        return Objects.equals(this.name, other.name) &&
                Objects.equals(this.club, other.club) &&
                this.overall == other.overall;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", club=" + club.getName() +
                ", overall=" + overall +
                '}';
    }

    public static class Builder {
        private String name;
        private Club club;
        private int overall;

        public Builder(String name) {
            this.name = name;
        }

        public Builder withClub(Club club) {
            this.club = club;
            return this;
        }

        public Builder withOverall(int overall) {
            this.overall = overall;
            return this;
        }

        public Player build() {
            return new Player(this);
        }
    }
}



