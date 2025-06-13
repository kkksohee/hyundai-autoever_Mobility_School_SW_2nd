package com.hd.sample_jpa_mysql_0605.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="board")
@Getter @Setter @ToString @NoArgsConstructor
public class Board {
    @Id
    @Column(name="board_id")
    //기본키 자동 생성 방식, DB의 auto_increment 사용
    //엔티티 저장할 때 INSERT가 먼저 실행되고 -> 생성된 ID가 DB로 부터 전달
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String title;

    @Lob
    private String content;
    private String image; //게시글에 첨부될 이미지 주소
    private LocalDateTime createTime;

    @PrePersist
    public void prePersist(){
        this.createTime = LocalDateTime.now();//DB에 쓰기 직전에 시간 포함
    }

    //JPA에서 데이터를 언제 불러올지(로딩전략)을 정하는 설정
    //필요할 때까지 해당 연관 데이터를 가져오지 않고, 실제로 접근할 때 DB에서 조회하도록 지연
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member; //회원 정보 객체 가져오기


}
