package com.hd.sample_jpa_mysql_0605.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder
public class TokenDto { //로그인 성공하면 토큰 dto로 정보를 날려줌
    private String grantType; //인증 방식
    private String accessToken;
    private String refreshToken;
    private Long accessTokenExpiresIn;
    private Long refreshTokenExpireIn;
}
