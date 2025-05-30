package 메소드연습_영화표예매;

import java.util.Scanner;

public class MovieMain {
    public static void main(String[] args) {
        MovieTicket movieTicket1 = new MovieTicket(12000);
        //예매하기,취소하기,종료하기 중 입력, 무한
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("[1]예매하기");
            System.out.println("[2]취소하기");
            System.out.println("[3]종료하기");
            int select=sc.nextInt();
            switch (select){
                case 1:
                    movieTicket1.selectSeat(); break;
                case 2:
                    movieTicket1.cancelSeat(); break;
                case 3:
                    System.out.println(movieTicket1.totalPrice()); return;
                default:
                    System.out.println("메뉴 선택이 잘 못 되었습니다.");
            }
        }
    }
}
