package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Entity
public class Player implements Comparable<Player>, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long uuid;
    private String name;
    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;
    private int overall;


    @Override
    public int compareTo(Player other) {
        return Integer.compare(this.overall, other.overall);
    }

}



