package com.hd.sample_jpa_mysql_0605.dto;

import com.hd.sample_jpa_mysql_0605.entity.Member;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

//요청(회원 정보)에 대한 응답
//회원가입에 대한 응답
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberResDto {
    private String email;
    private String name;
//    private String pwd;
    private String image;
    private LocalDateTime regDate;

    //빌더 패턴
    public static MemberResDto of(Member member) {
        return MemberResDto.builder()
                .name(member.getName())
                .email(member.getEmail())
                .image(member.getImage())
                .regDate(member.getRegDate())
                .build();
    }
}
