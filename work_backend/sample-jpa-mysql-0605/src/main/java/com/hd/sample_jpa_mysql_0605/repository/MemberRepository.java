package com.hd.sample_jpa_mysql_0605.repository;

import com.hd.sample_jpa_mysql_0605.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    // 이메일 존재 여부 확인 (존재 시 true 반환)
    //쿼리 메소드 작명 규칙 existBy
    boolean existsByEmail(String email);
    //이메일로 회원 정보 가져오기, Optional: null(자바에서 예외처리 x)을 처리하기 위해서 사용
    Optional<Member> findByEmail(String email);
    //로그인을 성공 실패를 위해 email, pwd 가 존재 여부 확인(둘 다 맞아야함)
    Optional<Member> findByEmailAndPwd(String email, String pwd);


}
