package com.hd.sample_jpa_mysql_0605.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "member")
@Getter @Setter
@NoArgsConstructor  //기본 생성자
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long id;

    @Column(length = 100) //이름 글자 100자로 제한
    private String name;

    @Column(nullable = false)
    private String pwd;//비밀번호 비어있으면 x

    @Column(unique = true, length = 150) //unique 중복체크
    private String email;

    @Column(length = 255)
    private String image;

    private LocalDateTime regDate;

    @PrePersist //DB에 INSERT 되기 전에 실행되는 메서드
    private void prePersist(){
        this.regDate = LocalDateTime.now();
    }

}
