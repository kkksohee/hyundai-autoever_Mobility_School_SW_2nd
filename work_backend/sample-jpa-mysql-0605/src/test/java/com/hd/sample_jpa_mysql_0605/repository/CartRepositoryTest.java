package com.hd.sample_jpa_mysql_0605.repository;

import com.hd.sample_jpa_mysql_0605.entity.Cart;
import com.hd.sample_jpa_mysql_0605.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

//카트를 만드려면 회원이 있어야 함.
@Slf4j //log 메시지를 출력하기 위해서 사용하는 lombok의 어노테이션
@SpringBootTest //스프링 컨텍스트를 로드하여 테스트 환경 설정
@Transactional  //여러개의 작업을 한개의 논리적인 작업단위로 묶어줌(레파지토리 묶기), 테스트 성공 실패와 상관없이 자동 롤백
@TestPropertySource(locations = "classpath:application-test.properties")
class CartRepositoryTest {
    @Autowired // 스프링 컨테이너에서 해당 빈에 해당하는 의존성을 주입 받음, 생성자를 통한 의존성 주입인 경우는 어노테이션 필요x
    CartRepository cartRepository;
    @Autowired
    MemberRepository memberRepository;

    @PersistenceContext //jpa에 있는 Entity manager
    EntityManager em;
    //회원 엔티티 생성
    //반환값으로 Member 객체
    public Member createMemberInfo(){
        Member member = new Member();
        //setId는 자동생성이라 해줄 필요 x autoIncrement
        member.setEmail("thgml@naver.com");
        member.setName("소히");
        member.setPwd("thgml123");
        member.setRegDate(LocalDateTime.now());
        return member;
    }
    @Test
    @DisplayName("장바구니와 회원 맵핑 조회 테스트")
    public void findCartAndMemberTest(){
        Member member = createMemberInfo(); //생성된 주소 반환 받음
        memberRepository.save(member); //DB에 회원 추가

        Cart cart = new Cart();
        cart.setCartName("자동차 구매 장바구니");
        cart.setMember(member);
        cartRepository.save(cart); //DB에 Insert

        em.flush(); // 영속성 컨테스트에 저장된 내용을 DB에 반영, 만들자마자 바로 DB에 넣으니까 빨리 넣으라는 뜻
        em.clear(); // 영속성 컨테스트 메모리 비우기

        //회원 조회 장바구늬 만들고 따로 따로 하면 문제가 없지만,
        //회원 조회와 장바구니를 하나의 작업 단위이기때문에 트랜잭션 필요
        //그중에 하나라도 실패하면 롤백이 일어나야 함
        Cart saveCart = cartRepository.findById(cart.getId())
                .orElseThrow(EntityExistsException::new);  //테스트 끝나면 자동 롤백, DB에 남지 않음

        log.info("Cart: {}",saveCart);

    }

}