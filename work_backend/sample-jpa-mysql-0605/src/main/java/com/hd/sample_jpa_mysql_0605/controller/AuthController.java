package com.hd.sample_jpa_mysql_0605.controller;

import com.hd.sample_jpa_mysql_0605.dto.MemberResDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@Slf4j  //Log 메시지 출력을 위한 어노테이션
@RestController  //ResAPI (GET, POST, DELETE, PUT)
//@CrossOrigin(origins = "http://localohst:5173") //
@RequestMapping("/auth") //auth로 들어온 애는 다 여기로 들어겠죠
public class AuthController {
    @PostMapping("/signup") //body에 정보를 실어서 넘어옴
    public ResponseEntity<MemberResDto> signup(@RequestBody MemberResDto memberRegDto){
        log.info("member: {}", memberRegDto); //log 정보 찍을 때
        MemberResDto memberResDto = new MemberResDto();
        memberResDto.setEmail(memberRegDto.getEmail());
        memberResDto.setName(memberRegDto.getName());
        memberResDto.setPwd(memberRegDto.getPwd());
        memberResDto.setImage("/test/test.img");
        memberResDto.setRegDate(LocalDateTime.now());
        return ResponseEntity.ok(memberResDto);
    }
    //로그인 Controller
    //post 방식: email, pwd를 Request Body 형식으로 수신
    //응답은 boolean 값으로 응답(true, false)
//    @PostMapping("/login")
//    public

    //회원 조회 Controller
    //Get 방식: email이 있으면 해당 회원 조회
    //없으면 전체 회원 조회
    //단 회원 정보 리스트는 서비스로직과 DB가 없으므로, for문으로 자체 생성
//    @GetMapping("/list")
//    public ResponseEntity<?> getMember(@)
//        log.error("email: {}",email);


}
