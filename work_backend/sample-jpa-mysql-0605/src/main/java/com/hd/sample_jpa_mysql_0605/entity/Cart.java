package com.hd.sample_jpa_mysql_0605.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="cart")
@Getter
@Setter
@ToString
//DB 테이블에 만들기 때문에 생성자 필요 없음
public class Cart {
    @Id
    @Column(name="card_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 128, nullable = false)
    private String cartName;

    @OneToOne //회원 Entity와 1대1 매피
    @JoinColumn(name="membr_id")  //여기서 외래키, 누군가의(member) 기본키
    private Member member; //생성된 회원 객체가 와야 함(회원이 있어야 카드를 만드니까)
    //해당하는 테이블의 객체 참조 주소가 필요


}
