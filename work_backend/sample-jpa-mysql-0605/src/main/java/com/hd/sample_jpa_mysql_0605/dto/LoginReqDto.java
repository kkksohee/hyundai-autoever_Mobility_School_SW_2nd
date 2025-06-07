package com.hd.sample_jpa_mysql_0605.dto;

import lombok.*;

//lombok? 이 해주는 것
@Getter
@Setter
@NoArgsConstructor //기본 생성자 (없으면 역직렬화 안일어남, 기본생성자 이용해서 역직렬화 검)
@AllArgsConstructor //매개변수가 전부 있는 생성자
//@Data //모든 옵션을 한번에 넣는 것
@ToString //자동 오버라이딩
public class LoginReqDto {
    private String email;
    private String pwd;
}
