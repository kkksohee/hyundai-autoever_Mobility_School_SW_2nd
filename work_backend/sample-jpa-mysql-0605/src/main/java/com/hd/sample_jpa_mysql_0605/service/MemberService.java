package com.hd.sample_jpa_mysql_0605.service;

import com.hd.sample_jpa_mysql_0605.dto.MemberReqDto;
import com.hd.sample_jpa_mysql_0605.dto.MemberResDto;
import com.hd.sample_jpa_mysql_0605.entity.Member;
import com.hd.sample_jpa_mysql_0605.repository.MemberRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletionException;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    //회원 전체 조회
    //페이지네이션 고민
    public List<MemberResDto> findAll(){
        List<Member> members = memberRepository.findAll(); //DB의 정보를 Entity에 담음
        List<MemberResDto> memberResDto = new ArrayList<>(); //DTO List생성
        for(Member member : members){ //하나의 요소값(Entity객체) 빼냄
            memberResDto.add(convertEntityToDto(member)); //member를 넣어서 한 개씩 다 변화가 일어남
        }
        return memberResDto;
    }
    //회원 상세 조회
    //컨트롤러에서 빼서 넣어준 것
    public MemberResDto findByEmail(String email) {
        Member member = memberRepository.findByEmail(email).orElseThrow(
                ()-> new RuntimeException("해당 회원이 존재하지 않습니다.")
        );
        return convertEntityToDto(member);
    }

    //회원 수정
    public boolean modifyMember(MemberReqDto memberReqDto){
        try{
            Member member = memberRepository.findByEmail(memberReqDto.getEmail()).orElseThrow(
                    ()-> new RuntimeException("해당 회원이 존재하지 않습니다.")
            );
            member.setName(memberReqDto.getName());
            member.setImage(memberReqDto.getImage());
            memberRepository.save(member);  //INSERT(값이 없으면), UPDATE(값이 있으면) save() 하나로 ㄷ
            return true;
        }catch (Exception e){
            log.error("회원 정보 수정 실패: {}", e.getMessage());
            return false;
        }
    }

    //회원 삭제
    public boolean deleteMember(String email){
        try{
            Member member = memberRepository.findByEmail(email).orElseThrow(
                    ()-> new RuntimeException("해당 회원이 존재하지 않습니다.")
            );
            memberRepository.delete(member);
            return true;
        }catch(Exception e){
            log.error("회원 정보 삭제 실패: {}",e.getMessage());
            return false;
        }
    }

    //Entity -> DTO 메서드
    private MemberResDto convertEntityToDto(Member member){
        MemberResDto memberResDto = new MemberResDto(); //DTO를 받기 위해 빈 Entity 객체
        memberResDto.setEmail(member.getEmail());
        memberResDto.setPwd(member.getPwd());
        memberResDto.setName(member.getName());
        memberResDto.setImage(member.getImage());
        memberResDto.setRegDate(member.getRegDate());
        return memberResDto;

    }

}
