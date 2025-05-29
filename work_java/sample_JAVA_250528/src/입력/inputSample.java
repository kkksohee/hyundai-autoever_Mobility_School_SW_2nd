package 입력;

import 접근제한자.Child;

import java.util.Scanner;
//이름, 주소, 성별, 나이를 입력받아서 출력하기
public class inputSample
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("이름 임력:");
        String name = sc.next(); //공백 기준으로 문자열 입력(띄어스기 없어야 할 때
        sc.nextLine();
        System.out.print("주소 입력: ");
        String addr = sc.nextLine(); // 줄바꿈 기준으로 한줄 전체 읽음(공백포함)
        System.out.print("성별입력");
        char gender = sc.next().charAt(0);
        System.out.print("나이 입력:");
        int age = sc.nextInt();

        System.out.println("이름: "+name);
        System.out.println( "주소: "+addr);
        System.out.println("성별: "+gender);
    }

    public static class CapsuMain {
        public static void main(String[] args) {
            Child child  = new Child();
            System.out.println(child.getName());
            System.out.println(child.getMoney());
            System.out.println(child.getAddr());
        }
    }
}
