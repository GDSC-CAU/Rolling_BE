package com.gdg.rolling.Dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetMembersDto {
    private Long id;
    private String emoji;
    private String name;
    private Integer x;
    private Integer y;

    public GetMembersDto(Long id, String emoji, String name, Integer x, Integer y) {
        this.id = id;
        this.emoji = emoji;
        this.name = name;
        this.x = x;
        this.y = y;
    }
}
