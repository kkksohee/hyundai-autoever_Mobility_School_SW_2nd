package com.hd.sample_jpa_mysql_0605.dto;
//프론트엔드에서 날려준 정보를 받아내는

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor //회원가입에 대한 요청
public class MemberRegDto {
    private String email;
    private String pwd;
    private String name;

}
