package com.hd.sample_jpa_mysql_0605.service;

import com.hd.sample_jpa_mysql_0605.dto.MemberReqDto;
import com.hd.sample_jpa_mysql_0605.dto.MemberResDto;
import com.hd.sample_jpa_mysql_0605.dto.TokenDto;
import com.hd.sample_jpa_mysql_0605.entity.Member;
import com.hd.sample_jpa_mysql_0605.jwt.TokenProvider;
import com.hd.sample_jpa_mysql_0605.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.Optional;

@Slf4j      //Log 정보를 출력하기 위한 롬복의 어노테이션
@Service    //Spring Container에 빈을 등록되어 있는 싱글톤 객체기 때문에
@Transactional  //여러개의 물리적 작업 단위를 논리적 단위로 묶음
@RequiredArgsConstructor // 생성자를 자동 생성
public class AuthService {
    // 의존성 주입 하지 않으면 new로 객체 생성해줘야 하고, 그럼 객체가 바뀔 수 있음
    private final MemberRepository memberRepository; // 생성자를 통한 의존성 주입을 받음
//    AuthService(MemberRepository memberRepository){
//        this.memberRepository = memberRepository;
//    }  //@RequiredArgsConstructor 가 대신
    private final AuthenticationManagerBuilder managerBuilder; // 인증을 담당하는 클래스
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    //회원가입
    public MemberResDto signUp(MemberReqDto memberReqDto){
        if (memberRepository.existsByEmail(memberReqDto.getEmail())) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다");
        }
        Member member = memberReqDto.toEntity(passwordEncoder);
        return MemberResDto.of(memberRepository.save(member));
    }
    // 로그인
    public TokenDto login(MemberReqDto requestDto) {
        UsernamePasswordAuthenticationToken authenticationToken = requestDto.toAuthentication();
        Authentication authentication = managerBuilder.getObject().authenticate(authenticationToken);
        return tokenProvider.generateTokenDto(authentication);
    }
//    //회원 가입 여부 확인 (회원 가입 input창에서 sever 갔다와서 여부 확인문구)
//    public boolean isMember(String email){
//        return memberRepository.existsByEmail(email);
//    }
//    //회원 가입
//    public boolean signUp(MemberReqDto memberReqDto){
//        try {
//            //DTO를 받아서 Entity로
//            Member member = convertDtoToEntity(memberReqDto);
//            memberRepository.save(member);
//            return true;
//        } catch (Exception e) {
//            log.error("회원 가입 시 오류 발생! : {}",e.getMessage());
//            return false;
//        }
//    }
//
//    //로그인
//    public boolean login(String email, String pwd){
//        Optional<Member> member = memberRepository.findByEmailAndPwd(email,pwd);
//        return member.isPresent(); //isPresent :객체 존재 여부 확인(Optional 클래스 안에 있음)
//    }
//
//    //DTO -> Entity Mapping 메서드
//    //내부에서 사용할려고 만들었음, controller 에서 부를 필요x
//    //처음 회원 가입할 때 이미지는 없기 때문에 x
//    private Member convertDtoToEntity(MemberReqDto memberReqDto){
//        Member member = new Member(); //빈 entity를 만듬. member 반환하면 됨
//        member.setEmail(memberReqDto.getEmail());
//        member.setPwd(memberReqDto.getPwd());
//        member.setName(memberReqDto.getName());
//        return member;
//    }
}
