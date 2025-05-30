package 자동차만들기;
//추상클래스
public abstract class Car {
    private int speed;
    private int cost;
    private int oilTank;
    private int seatNum;
    private String carName;

    //총 이동 횟수 계산
    //주유 횟수 계산
    //총 비용 계산
    //총 이동 시간 계산

    //추상 메서드 - 부가 기능
    abstract void setMode(boolean isOn);
}
