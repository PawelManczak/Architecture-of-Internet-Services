package com.example.demo.DTO;

import com.example.demo.Club;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PutPlayerRequest {
    private String name;
    private String clubName;
    private int overall;
}
