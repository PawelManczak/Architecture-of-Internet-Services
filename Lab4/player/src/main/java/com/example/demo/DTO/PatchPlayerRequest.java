package com.example.demo.DTO;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PatchPlayerRequest {
    private Long id;
    private String name;
    private Long clubId;
    private int overall;
}
