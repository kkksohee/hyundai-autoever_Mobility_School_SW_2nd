package com.hd.sample_jpa_mysql_0605.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {
    private SecurityUtil() { }

    //토큰 정보에서 해당하는 사용자 빼오는 것
    //왜 이메일이 아니고 id를 빼오는건지?
    public static Long getCurrentMemberId() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || authentication.getName() == null) {
            throw new RuntimeException("Security Context에 인증 정보가 없습니다.");
        }

        return Long.parseLong(authentication.getName()); //확인필요
    }
}
