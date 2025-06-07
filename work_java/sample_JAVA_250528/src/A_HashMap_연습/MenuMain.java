package A_HashMap_연습;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class MenuMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, MenuInfo> pro = new HashMap<>();
        pro.put("Americano",new MenuInfo("Americano", 2000, "Coffee", "기본커피"));
        pro.put("Espresso", new MenuInfo("Espresso", 2500, "Coffee", "진한커피")));
        pro.put("Latte", new MenuInfo("Latte", 4000, "Coffee", "우유 포함"));

        while(true){
            System.out.print("[1]메뉴보기, [2]메뉴조회, [3]메뉴추가, " +
                    "[4]메뉴삭제, [5]메뉴수정, [6]종료 :");
            int choose=sc.nextInt();
            switch(choose){
                case 1:
                    System.out.print("--메뉴보기--");
                    for(String e : pro.keySet()){

                    }

            }
        }
    }
}
