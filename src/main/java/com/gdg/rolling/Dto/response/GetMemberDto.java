package com.gdg.rolling.Dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetMemberDto {
    private Long id;
    private String emoji;
    private String name;
    private String video;
    private String phone;
    private String instagram;
    private String ps;

    public GetMemberDto(Long id, String emoji, String name, String video, String phone, String instagram, String ps) {
        this.id = id;
        this.emoji = emoji;
        this.name = name;
        this.video = video;
        this.phone = phone;
        this.instagram = instagram;
        this.ps = ps;
    }
}
