package com.example.demo.DTO;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode

public class GetPlayerResponse {
    private long uuid;
    private String name;
    private String clubName;
    private int overall;

}
