package com.gdg.rolling.Dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetPapersDto {
    private Long id;
    private String name;

    public GetPapersDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
