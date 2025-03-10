package com.gdg.rolling.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String emoji;
    private String name;
    private String video;
    private String phone;
    private String instagram;
    private String ps;
    private Integer x;
    private Integer y;

    @ManyToOne
    @JoinColumn(name = "paper_id")
    private Paper paper;

    @Builder
    public Member(String emoji, String name, String video, String phone,
                  String instagram, String ps, Integer x, Integer y, Paper paper) {
        this.emoji = emoji;
        this.name = name;
        this.video = video;
        this.phone = phone;
        this.instagram = instagram;
        this.ps = ps;
        this.x = x;
        this.y = y;
        this.paper = paper;
    }
}