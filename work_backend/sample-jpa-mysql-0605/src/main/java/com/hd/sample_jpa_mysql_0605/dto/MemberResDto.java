package com.hd.sample_jpa_mysql_0605.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

//요청(회원 정보)에 대한 응답
//회원가입에 대한 응답
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberResDto {
    private String email;
    private String name;
    private String pwd;
    private String image;
    private LocalDateTime regDate;
}
