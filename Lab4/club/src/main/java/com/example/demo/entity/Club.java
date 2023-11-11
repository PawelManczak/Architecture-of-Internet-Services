package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Entity
public class Club implements Comparable<Club>, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "club_id")
    private long uuid;
    private String name;
    @Column
    private int stars;
    @OneToMany(mappedBy = "club", cascade=CascadeType.ALL)
    private List<Player> players;



    @Override
    public int compareTo(Club other) {
        return this.name.compareTo(other.name);
    }

}


