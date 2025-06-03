package 자동차만들기;

import static java.lang.Math.ceil;

//추상클래스
public abstract class Car {
    protected int speed;
    protected int fuelCost;
    protected int oilTank;
    protected int seatNum;
    protected String carName;

    //총 이동 횟수 계산
    public int moveCnt(int people){
        if(people%this.seatNum != 0) return people/this.seatNum+1;
        return people/this.seatNum;

    }
    //총 이동 거리: 거리 * 횟수
    //총 연료 소모량: 거리/연비
    //총 주유 횟수 : 총연료 소모량 / 연료탱크 크기
    //주유 횟수 계산
    public int fuelCnt(int distance, int people){
//        if(this.fuelCost*this.oilTank>distance) return 1;
//        else if((this.fuelCost*this.oilTank)%distance != 0){
//            return (this.fuelCost*this.oilTank)/distance+1;
//        }
//        return (this.fuelCost*this.oilTank)/distance;
        int totalDistance = distance*moveCnt(people);
        int totalOil = totalDistance/this.fuelCost;
        if(totalOil<this.oilTank) return 1;
        else if(totalOil%this.oilTank !=0) return totalOil/this.oilTank+1;
        else return totalOil/this.oilTank;
    }
    //총 비용 계산 : 소모량 *2000
    public int totalCost(int distance, int people){
        int totalDistance = distance*moveCnt(people);
        int totalOil = totalDistance/this.fuelCost;
        return totalOil*2000;
    }
    //총 이동 시간 계산
//    public int moveTime(int distance, int weather){
//        switch(weather){
//            case 2:
//                weather = 1.2;
//        }
//    }

    //추상 메서드 - 부가 기능
    abstract void setMode(boolean isOn);
}
