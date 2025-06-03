package ArrayList응용예제;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Order {
    //변수
    private final ArrayList<Product> products;
    private BigDecimal total;

    //생성자
    Order(){
        products = new ArrayList<>();
        this.total = BigDecimal.ZERO;
    }
    public void addItem(Product product){
        products.add(product);
        this.total = total.add(product.getPrice());

    }
    public Product getItem(String name){
        for(Product product : products){
            if(product.getName().equals(name)) return product;
        }
        return null;
    }
    public boolean removeItem(String name){
        for(Product product : products){
            if(product.getName().equals(name)){
                products.remove(product);
                total=total.subtract(product.getPrice()); //뺄셈
                return true;
            }
        }return false;
    }
    public BigDecimal calculateFinalPrice(BigDecimal taxRate){
        //계산식: total +(total*taxRate)
        //소수점 둘째자리에서 반올림
        BigDecimal taxAmount = total.multiply(taxRate); //total*taxRate
        BigDecimal finalPrice = total.add(taxAmount); //total+
        return finalPrice.setScale(2, RoundingMode.HALF_UP);
    }
    //ArrayList<Product>을 반환값으로 가지는 getproduct()메소드
    public ArrayList<Product> getProduct(){
        return products;
    }
}