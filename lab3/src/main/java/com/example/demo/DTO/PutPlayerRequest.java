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
    private Club club;
    private int overall;
}
