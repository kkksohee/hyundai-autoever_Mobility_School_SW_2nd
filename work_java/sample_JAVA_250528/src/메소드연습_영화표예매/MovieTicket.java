package 메소드연습_영화표예매;

import java.util.Scanner;

public class MovieTicket {
    //10개 좌석 배열
    //좌석당 가격에 대한 인스턴스필드
    //입력을 받기 위한 스캐너 객체 생성
    private final int[] seat = new int[10];
    private final int seatPrice;
    private final Scanner sc =new Scanner(System.in);

    //생성자: 좌석당 가격 정보를 객체 생성시 넣어야 되므로
    //매개변수가 있는 생성자 필요
    public MovieTicket(int price){
        this.seatPrice=price;
    }
    //좌석 상태 표시 메서드 구현
    public void printSeat(){
        for(int e : seat){
            if(e==1) System.out.print("[V]");
            else System.out.print("[ ]");
        }System.out.println();
    }
    //좌석 예약 메서드 구현
    public void selectSeat(){
        printSeat();
        System.out.print("좌석을 선택하세요: ");
        int seatPos=sc.nextInt();
        if(seatPos<=0 || seatPos >10 ) {
            System.out.println("잘못 선택하셨습니다. 프로그램을 종료합니다.");
            return ;
        }
        if(seat[seatPos-1]==1) System.out.println("이미 예약된 자리입니다.");
        else{
            seat[seatPos-1]=1;
            System.out.println("예약되었습니다.");
            printSeat();
        }
    }
    //좌석 상태-> 좌석 번호 입력-> 자리 있으면 예매, 없으면 예매 되었다

    //예약 취소하기 구현
    //좌석상태->취소할 좌석 입력-> 예매 되있으면 취소 없으면 빈자리
    public void cancelSeat(){
        printSeat();
        System.out.print("취소할 자리를 선택하세요");
        int cancel=sc.nextInt();
        if(seat[cancel-1]==1) {
            seat[cancel-1]=0;
            System.out.println("취소 되었습니다.");
        }else{
            System.out.println("예약된 좌석이 아닙니다.");
        }

    }
    //총 판매금액
    //배열 순회로 예매체크 값 바로 반환
    public int totalPrice(){
        int cnt=0;
        for(int e: seat){
            if(e==1) cnt++;
        }return cnt*seatPrice;
    }


}
