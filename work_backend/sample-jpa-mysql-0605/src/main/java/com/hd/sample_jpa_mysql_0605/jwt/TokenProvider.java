package com.hd.sample_jpa_mysql_0605.jwt;

import com.hd.sample_jpa_mysql_0605.dto.TokenDto;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Component //스프링 컨테이너에 등록 다 얘를 상속 받아서 사용함
@Slf4j
public class TokenProvider {
    private static final String AUTHORITIES_KEY = "auth"; // 권한 정보를 저장하는 키
    private final Key key; // JWT 서명에 사용할 비밀키, security key import

    private static final String BEARER_TYPE ="Bearer";

    // 비밀키를 기반으로 키 객체 초기화
    // 주의점 : @Value 어노테이션은 springframework의 어노테이션이다.
    public TokenProvider(@Value("${jwt.secret}") String secretKey) { //springframwork로 넣어야 함 lombok아님
        this.key = Keys.hmacShaKeyFor(secretKey.getBytes());
    }
    // 토큰 생성 메서드
    public TokenDto generateTokenDto(Authentication authentication) {
        // 인증 객체에서 권한 정보 추출
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        // 현재 시간과 토큰 만료 시간 계산
        long now = (new Date()).getTime();
        Date accessTokenExpiresIn = new Date(now + 30 * 60 * 1000); // 30분
        Date refreshTokenExpiresIn = new Date(now + 60* 60 *24 * 1000); //1일

        // Access Token 생성
        String accessToken = Jwts.builder()
                .setSubject(authentication.getName()) // 사용자명 설정, 이메일이 들어 있음
                .claim(AUTHORITIES_KEY, authorities)  // 권한 정보 저장
                .setExpiration(accessTokenExpiresIn)  // 만료 시간 설정
                .signWith(key, SignatureAlgorithm.HS512) // 서명 방식 설정
                .compact();

        //reFlash token 생성
        String refreshToken = io.jsonwebtoken.Jwts.builder()
                .setExpiration(refreshTokenExpiresIn)
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();

        // 결과를 DTO로 반환
        //빌드 패턴 순서에 상관없이 넣어도 됨
        return TokenDto.builder()
                .grantType("Bearer")
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .accessTokenExpiresIn(accessTokenExpiresIn.getTime())
                .refreshTokenExpireIn(refreshTokenExpiresIn.getTime())
                .build();
    }

    // 토큰에서 인증 객체 생성
    public Authentication getAuthentication(String token) {
        //토큰 복호화
        Claims claims = parseClaims(token);

        // 토큰 복호화에 실패하면
        if (claims.get(AUTHORITIES_KEY) == null) {
            throw new RuntimeException("권한 정보가 없는 토큰입니다.");
        }

        // 권한 정보 추출
        Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        // 인증 객체 생성 후 반환
        User principal = new User(claims.getSubject(), "", authorities);
        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
    }
    // 토큰 유효성 검증
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (SecurityException | io.jsonwebtoken.MalformedJwtException e) {
            log.info("잘못된 JWT 서명입니다.");
        } catch (ExpiredJwtException e) {
            log.info("만료된 JWT 토큰입니다.");
        } catch (UnsupportedJwtException e) {
            log.info("지원되지 않는 JWT 토큰입니다.");
        } catch (IllegalArgumentException e) {
            log.info("JWT 토큰이 잘못되었습니다.");
        }
        return false;
    }

    // 토큰의 Claims(내용) 추출
    private Claims parseClaims(String token) { //사용자에 대한 이메일, id 를 넣을 수 있음
        try {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }

}
