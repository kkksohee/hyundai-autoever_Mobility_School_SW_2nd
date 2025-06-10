package com.hd.sample_jpa_mysql_0605.entity;

import com.hd.sample_jpa_mysql_0605.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString //원래 해시코드 출력,오버라이딩 하면 내부의 필드 값 출력으로 바꿔줌
@Entity //해당 클래스가 엔티티임을 나타냄, 즉 DB table로 생성됨
@Table(name="item") //해당 클래스가 db table로 생성 시 생성될 이름 지정, 소문자로 생성 table이 클래스 이름과 달라서 바꿔줘야 할 때
public class Item {
    @Id // 기본키 필드 지정, 유일한 값, not null, entity에서는 반드시 필요
    @Column(name="item_id") //db로 생성된 컬럼 이름을 지정
    @GeneratedValue(strategy = GenerationType.AUTO) //기본키 생성 전략, JPA가 DB에 맞게 생성전략 결정
    private Long id;

    @Column(nullable = false, length = 50)
    private String itemNm; //상품명

    @Column(name="price", nullable = false)
    private int price;

    @Column(nullable = false) //이름을 안정했다면: stock_number로 저장 됨,스네이크 표기법으로 자동 변경 됨
    private int stockNumber; //재고 수량

    @Lob  //대용량 문자열 처리
    @Column(nullable = false)
    private String itemDetail;

    @Enumerated(EnumType.STRING) //enum을 문자열로 DB에/ORDINAL: 순서 정의
    private ItemSellStatus itemSellStatus; //SELL,SOUL_OUT 만

    private LocalDateTime regTime;
    private LocalDateTime updateTime;

}
