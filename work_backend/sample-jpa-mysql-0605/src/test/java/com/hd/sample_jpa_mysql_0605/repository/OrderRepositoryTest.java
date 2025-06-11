package com.hd.sample_jpa_mysql_0605.repository;

import com.hd.sample_jpa_mysql_0605.constant.ItemSellStatus;
import com.hd.sample_jpa_mysql_0605.entity.Item;
import com.hd.sample_jpa_mysql_0605.entity.Member;
import com.hd.sample_jpa_mysql_0605.entity.Order;
import com.hd.sample_jpa_mysql_0605.entity.OrderItem;
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

import static org.junit.jupiter.api.Assertions.*;

@Slf4j //log 메시지를 출력하기 위해서 사용하는 lombok의 어노테이션
@SpringBootTest
@Transactional  //여러개의 작업을 한개의 논리적인 작업단위로 묶어줌(레파지토리 묶기), 테스트 성공 실패와 상관없이 자동 롤백
@TestPropertySource(locations = "classpath:application-test.properties")
class OrderRepositoryTest {
    //의존성 주입
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ItemRepository itemRepository;
    @PersistenceContext
    EntityManager em;

    @Autowired
    MemberRepository memberRepository;

    public Item createItem(){
        Item item = new Item();
        item.setItemNm("테스트 상품");
        item.setPrice(20000);
        item.setItemDetail("상세 설명");
        item.setItemSellStatus(ItemSellStatus.SELL); //enum타입
        item.setStockNumber(100);
        return item;
    }
    @Test
    @DisplayName("영속성 전의 테스트")
    public void cascadeTest(){
        Order order = new Order();
        for(int i=0; i<5; i++){
            Item item = this.createItem(); //아이템 5개 만들어짐
            itemRepository.save(item);
            OrderItem orderItem = new OrderItem();
            orderItem.setItem(item);
            orderItem.setCount(10);
            orderItem.setOrderPrice(3000);
            orderItem.setOrder(order);
            //아직 영속성 컨텍스트에 저장되지 않은 orderItem 엔티티를 order 엔티티에 담아줍니다.
            order.getOrderItemList().add(orderItem);
        }
        //오버 한 후 Flush
        orderRepository.saveAndFlush(order);
        em.clear(); // 영속성 상태를 초기화
        Order saveOrder = orderRepository.findById(order.getId())
                .orElseThrow(EntityExistsException::new);
        assertEquals(5,saveOrder.getOrderItemList().size());
    }

//    public Order createOrder(){
//        Order order = new Order();
//
//        for(int i=0; i<3; i++){
//            Item item = createItem();
//            itemRepository.save(item);
//            OrderItem orderItem = new OrderItem();
//            orderItem.setItem(item);
//            orderItem.setCount(10);
//            orderItem.setOrderPrice(1000);
//            orderItem.setOrder(order);
//            order.getOrderItemList().add(orderItem);
//        }
//
//        Member member = new Member();
//        memberRepository.save(member);
//
//        order.setMember(member);
//        orderRepository.save(order);
//        return order;
//    }
//    @Test
//    @DisplayName("고아 객체 제거 테스트")
//    public void orphanRemovalTest(){
//        Order order = this.createOrder();
//        // 주문 항목의 리스트를 가져와서 첫번째 항목 제거하는 것은 해당 객체를 데이터베이스에서도 삭제하는 것돠 동일
//        order.getOrderItemList().remove(0);
//        em.flush(); // 즉시 데이터베이스에 반영
//    }

}