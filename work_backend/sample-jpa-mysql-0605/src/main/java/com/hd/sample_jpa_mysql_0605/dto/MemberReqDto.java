package com.hd.sample_jpa_mysql_0605.dto;
//프론트엔드에서 날려준 정보를 받아내는

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//회원 정보
@Getter
@Setter
@NoArgsConstructor //회원가입에 대한 요청, JSON역직렬화 할 때 빈 생성자를 사용함! 넣어줘야함!
public class MemberReqDto {
    private String pwd;
    private String name;
    private String image;
    private String email;

}
