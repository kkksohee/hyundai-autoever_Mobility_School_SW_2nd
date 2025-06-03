package ArrayList응용예제;

import java.math.BigDecimal;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Order order = new Order();

        while(true){
            //Product p; //= new Product(sc.next(), sc.next());
            System.out.println("\n==== 주문 관리 시스템 ====");
            System.out.println("1. 제품 추가");
            System.out.println("2. 제품 제거");
            System.out.println("3. 제품 목록 보기");
            System.out.println("4. 제품 보기");
            System.out.println("5. 최종 가격 계산 (세금 포함)");
            System.out.println("6. 종료");
            System.out.print("원하는 작업을 선택하세요: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:{
                    System.out.print("제품 이름을 입력하세요: ");
                    String name = sc.nextLine();
                    System.out.print("제품 가격을 입력하세요 (예: 3.25): ");
                    String price = sc.nextLine();
                    order.addItem(new Product(name, price));
                    System.out.println(name+"제품이 추가 되었습니다.");
                    break;}
                case 2:{
                    System.out.println("제거할 제품을 입력하세요");
                    String name = sc.nextLine();
                    if(order.removeItem(name)){
                        System.out.println(name+"제품이 제거되었습니다.");
                    }else{
                        System.out.println("해당 이름의 제품을 찾을 수 없습니다.");
                    }
                    break;
                }
                case 3:{
                    System.out.println("---제품 목록---");
                    for(Product product : order.getProduct()){
                        System.out.println(product.getName() +"-$"+product.getPrice());
                    }break;
                }
                case 4:
                    System.out.println("---제품 검색---");
                    String findName = sc.nextLine();
                    Product product = order.getItem(findName);
                    if(product != null){
                        System.out.println(product.getName()+ " - $" + product.getPrice());
                    }else{
                        System.out.println("해당 제품을 찾을 수 없습니다.");
                    }
                    break;
                case 5:
                    System.out.println("세율을 입력하세요 (예: 0.06 for 6%):");
                    BigDecimal tax = sc.nextBigDecimal();
                    System.out.println("최종금액은 "+order.calculateFinalPrice(tax)+"입니다.");
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택 하세요.");
            }
        }

    }
}
