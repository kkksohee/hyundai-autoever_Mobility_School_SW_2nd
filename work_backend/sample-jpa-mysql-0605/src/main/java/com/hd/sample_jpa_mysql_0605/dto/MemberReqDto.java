package com.hd.sample_jpa_mysql_0605.dto;
//프론트엔드에서 날려준 정보를 받아내는

import com.hd.sample_jpa_mysql_0605.constant.Authority;
import com.hd.sample_jpa_mysql_0605.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

//회원 정보
@Getter
@Setter
@NoArgsConstructor //회원가입에 대한 요청, JSON역직렬화 할 때 빈 생성자를 사용함! 넣어줘야함!
public class MemberReqDto {
    private String pwd;
    private String name;
    private String image;
    private String email;

    //PasswordEncoder 매개변수로 받아 Member 객체로 변환하는 메소드
    public Member toEntity(PasswordEncoder passwordEncoder) {
        return Member.builder()
                .email(email)
                .pwd(passwordEncoder.encode(pwd))
                .name(name)
                .image(image)
                .authority(Authority.ROLE_USER)
                .build();
    }
    //토큰을 객체로 변환하여 반환하는 메소드, 이메일과 비번 일치하는지 검증
    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(email, pwd);
    }

}
