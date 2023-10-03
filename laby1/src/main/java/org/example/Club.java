package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
public class Club implements Comparable<Club> {
    private String name;
    private int stars;
    @Setter
    private List<Player> players;

    private Club(Builder builder) {
        this.name = builder.name;
        this.stars = builder.stars;
        this.players = builder.players;
    }

    @Override
    public int compareTo(Club other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, stars);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Club)) return false;
        Club other = (Club) obj;
        return Objects.equals(this.name, other.name) &&
                this.stars == other.stars;
    }

    @Override
    public String toString() {
        return "Club{" +
                "name='" + name + '\'' +
                ", stars=" + stars +
                '}';
    }

    public static class Builder {
        private String name;
        private int stars;
        private List<Player> players;

        public Builder(String name) {
            this.name = name;
        }

        public Builder withStars(int stars) {
            this.stars = stars;
            return this;
        }

        public Builder withPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Club build() {
            return new Club(this);
        }
    }
}


