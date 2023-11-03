package com.example.demo.DTO;

import com.example.demo.Player;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetClubResponse {
    private long uuid;
    private String name;
    private List<String> players;
    private int stars;
}
