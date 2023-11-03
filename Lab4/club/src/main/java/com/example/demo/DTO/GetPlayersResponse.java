package com.example.demo.DTO;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetPlayersResponse {
    /**
     * Represents single player in list.
     */
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Player {

        /**
         * Unique id identifying player.
         */
        private long id;

        /**
         * fullname of the player.
         */
        private String name;
        private String clubName;

    }

    /**
     * List of all players.
     */
    @Singular
    private List<Player> players;

}
