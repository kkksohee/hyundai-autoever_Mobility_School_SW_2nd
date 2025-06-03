package ArrayList응용예제;

import java.math.BigDecimal;

public class Product {
    //final 값을 변경 불가지만, 나중에 한 번 대입 가능
    private final String name;
    private final BigDecimal price;

    //생성자
    Product(String name, String price){
        //여기서 대입
        this.name = name;
        this.price = new BigDecimal(price);
    }
    //메서드
    public String getName(){return this.name;}
    public BigDecimal getPrice(){return this.price;}
}
