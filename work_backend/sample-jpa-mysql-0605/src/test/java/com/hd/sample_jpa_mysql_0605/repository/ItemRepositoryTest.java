package com.hd.sample_jpa_mysql_0605.repository;


import com.hd.sample_jpa_mysql_0605.constant.ItemSellStatus;
import com.hd.sample_jpa_mysql_0605.entity.Item;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;


import java.time.LocalDateTime;
import java.util.List;

@Slf4j //log 메시지를 출력하기 위해서 사용하는 lombok의 어노테이션
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class ItemRepositoryTest {
    //ItemRepository는 Item 엔티티의 DB 접근을 담당하는 객체
    //테스트 클래스에서 DB에 데이터를 넣거나, 조회하려면 itemRepository를 써야 함
    @Autowired //의존성 주입
    ItemRepository itemRepository; //필드 의존성 주입을 받음

    @Test
    @DisplayName("상품 저장 테스트")
    public void createTest(){
        Item item = new Item();
        item.setItemNm("테스트 상품");
        item.setPrice(10000);
        item.setItemDetail("테스트 상품 설명");
        item.setItemSellStatus(ItemSellStatus.SELL);
        item.setStockNumber(100);
        item.setRegTime(LocalDateTime.now()); //현재시간
        item.setUpdateTime(LocalDateTime.now()); //업데이트 시간
        Item savedItem = itemRepository.save(item); //item 객체를 DB에 저장하는 명령
        //log.debug("Item : {}", savedItem);
    }

    public void createItemList(){
        for(int i=1; i<=10; i++){
            Item item = new Item();
            item.setItemNm("테스트 상품"+i);
            item.setPrice(10000+i);
            item.setItemDetail("테스트 상품 설명"+i);
            item.setItemSellStatus(ItemSellStatus.SELL);
            item.setStockNumber(100);
            item.setRegTime(LocalDateTime.now()); //현재시간
            item.setUpdateTime(LocalDateTime.now()); //업데이트 시간
            Item savedItem = itemRepository.save(item); //새로운 아이템 추가, INSERT,UPDATE
            //log.debug("Item : {}", savedItem);
        }
    }

    @Test
    @DisplayName("상품명 조회 테스트")
    public void findByItemNmTest(){
        this.createItemList(); //10개의 아이템을 생성
        List<Item> list = itemRepository.findByItemNm("테스트 상품5"); //반환을 list로 받음
        for(Item item : list){
            log.info("Item: {}",item);
            log.error("Item: {}",item);
        }
    }

    @Test
    @DisplayName("상품명 or 상품상세 설명")
    public void findByItemNmOrItemDetailTest(){
        this.createItemList();
        List<Item> list = itemRepository
                .findByItemNmOrItemDetail
                        ("테스트 상품7", "테스트 상품 설명3");
        for(Item item : list){
            log.info("item: {}",item);
        }
    }
    @Test
    @DisplayName("@Query를 이용한 상품 조회 테스트")
    public void findByItemDetailTest(){
        this.createItemList();
        List<Item> list = itemRepository.findByItemDetail("테스트 상품 설명9");
        for(Item item : list){
            log.info("item :{}",item);
        }
    }

    @Test
    @DisplayName("native Query 테스트")
    public void findByItemDetailByNative(){
        this.createItemList();
        List<Item> list = itemRepository.findBITemDetailByNative("테스트 상품 설명2");
        for(Item item : list){
            log.info("item: {}",item);
        }
    }
}