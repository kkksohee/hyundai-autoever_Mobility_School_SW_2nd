package HashMap_커피메뉴만들기;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//CRUD
public class MenuMain {
    static Map<String,MenuInfo> map = new HashMap<>();
    public static void main(String[] args) {
        MenuMain.makeMenu(); //같은 클래스 이기 때문에 생략 가능, 객체 생성 없이 가능(static)
        selectMenu();

    }
    //클래스 메서드 -> 객체 안만들어도됨
    static void makeMenu(){
        map.put("Americano", new MenuInfo("Americano",2000,"coffee","기본커피"));
        map.put("Espresso", new MenuInfo("Espresso",1500,"coffee","진한커피"));
        map.put("Latte", new MenuInfo("Latte",2500,"coffee","우유커피"));
    }
    static void selectMenu(){
        Scanner sc = new Scanner(System.in);
        String key;
        while(true){
            System.out.println("메뉴를 선택하세요");
            System.out.println("[1]메뉴보기, [2]메뉴조회, [3]메뉴추가, [4]메뉴삭제, [5]메뉴수정, [6]종료 :");
            int selMenu = sc.nextInt();
            sc.nextLine();
            switch(selMenu){
                case 1:
                    System.out.println("-".repeat(4)+"메뉴보기"+"-".repeat(4));
                    //map.ketSet():이터러블객체, 키 값 기준으로 순회해야함
                    //k값이 하나의 요소로 넘어옴 = key
                    //map중에 key값을 set으로 불러옴(set은 중복허용x)
                    for(String k : map.keySet()){//향상된 for문으로 순회하기 위해서는 key 기준 순회
                        System.out.println("이름: "+map.get(k).name);//get:key값을 던져서 값을 빼내는 것
                        System.out.println("가격: "+map.get(k).price);
                        System.out.println("분류: "+map.get(k).category);
                        System.out.println("상세설명: "+map.get(k).desc);
                        System.out.println("-----------");
                    }
                    break;
                case 2:
                    System.out.print("조회할 메뉴를 입력하세요: ");
                    key= sc.nextLine(); //메뉴 입력
                    if(map.containsKey(key)){//key의 포함 여부 확인
                        System.out.println("이름: "+map.get(key).name);
                        System.out.println("가격: "+map.get(key).price);
                        System.out.println("분류: "+map.get(key).category);
                        System.out.println("상세설명: "+map.get(key).desc);
                    }else{
                        System.out.println("해당 메뉴가 존재하지 않습니다.");
                    }
                    break;
                case 3:
                    System.out.print("추가 할 메뉴를 입력하세요: ");
                    key = sc.nextLine();
                    if(!map.containsKey(key)){
                        System.out.print("가격 입력: ");
                        int price = sc.nextInt();
                        sc.nextLine();
                        System.out.print("분류 입력: ");
                        String cate = sc.nextLine();
                        System.out.print("설명 입력: ");
                        String desc = sc.nextLine();
                        map.put(key, new MenuInfo(key, price, cate, desc));
                    }else{
                        System.out.println("해당 메뉴가 이미 존재합니다.");
                    }
                    break;
                case 4:
                    System.out.print("삭제할 메뉴를 입력하세요: ");
                    key=sc.nextLine();
                    if(map.containsKey(key)){
                        map.remove(key);
                        System.out.println(key+"메뉴가 삭제 되었습니다.");
                    }else{
                        System.out.println("해당 메뉴가 존재하지 않습니다.");
                    }
                    break;
                case 5: //replace(): 해당 키가 존재해야함.
                    System.out.print("수정할 메뉴를 입력하세요: ");
                    key=sc.nextLine();
                    if(map.containsKey(key)){
                        System.out.print("가격 입력: ");
                        int price = sc.nextInt();
                        sc.nextLine();
                        System.out.print("분류 입력: ");
                        String cate = sc.nextLine();
                        System.out.print("설명 입력: ");
                        String desc = sc.nextLine();
                        boolean replace;
                        map.replace(key,new MenuInfo(key, price, cate,desc));
                    }else{
                        System.out.println("해당 메뉴가 존재하지 않습니다.");
                    }
                    break;
                case 6:
                    System.out.println("종료합니다. 안녕!");
                    return;

            }
        }
    }
}
