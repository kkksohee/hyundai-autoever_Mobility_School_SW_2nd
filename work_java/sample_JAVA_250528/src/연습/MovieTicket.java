package 연습;

public class MovieTicket {
    //10개 좌석 배열
    //좌석당 가격
    private final int[] seat = new int[10];
    private int seatPrice;
    private int totalPrice;
    //생성자
    public MovieTicket(){
        seatPrice=12000;
    }
    //예약하기 몇개의 좌석을 예약할건지
    public void TicketGet(int num){
        while (num>=0){
            seat[num-1]=1;
            num--;
        }
    }
    //메서드구현
    //예매 취소 메서드
    //극장 좌석 선택 메소드
    //총 판매 금액

}
