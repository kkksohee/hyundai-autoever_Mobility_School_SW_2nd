package com.hd.sample_jpa_mysql_0605.repository;

import com.hd.sample_jpa_mysql_0605.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//JpaRepository의 기본타입을 Long으로
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    //기본적인 CRUD는 만들어져 있음
    List<Item> findByItemNm(String itemNm); //SELECT * FROM item WHERE item_nm = ''
    List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);
    //@Query : JPQL과 nativeQuery
    //JPQL : 객체지향언어로 쿼리를 작성, 쿼리메서드로 작성하기 힘든 복잡한 쿼리 작성 가능, JPQL문법 숙지 필요
    //itemDetail : 카멜표기법-실제 물리적인 db를 바라보는게 아니고, 아직까지 엔티티매니저에 있는 item클래스의 itemDetail을 바라봄
    //Item을 i 라고 별칭을 줘야함
    @Query("SELECT i FROM Item i WHERE i.itemDetail like %:itemDetail% ORDER BY i.price desc ")
    List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);

    //nateQuery: 해당하는 db의 실제 쿼리를 작성, 복잡한 쿼리 작성 가능, 스네이크 표기법(실제 db 바라보고 있음)
    @Query(value = "SELECT * FROM item i WHERE i.item_detail like %:itemDetail% ORDER BY i.price desc",nativeQuery = true)
    List<Item> findBITemDetailByNative(@Param("itemDetail") String itemDetail);
}
