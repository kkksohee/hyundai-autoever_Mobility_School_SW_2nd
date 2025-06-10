package com.hd.sample_jpa_mysql_0605.entity;

import com.hd.sample_jpa_mysql_0605.constant.OrderStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue
    @Column(name="order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member; //해당하는 객체의 주소 대입

    private LocalDateTime orderDate; //주문일

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private LocalDateTime regTime;

    //cascade = CascadeType.ALL :부모 엔티티가 영속성 컨텍스트에 등록되거나 삭제될 때, 연관된 자식 엔티티들도 함께 변화가 적용
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL,orphanRemoval = true) //mappedBy:누가 주인인지 알려줌(실제 생성이 부모)
    private List<OrderItem> orderItemList = new ArrayList<>();
}
