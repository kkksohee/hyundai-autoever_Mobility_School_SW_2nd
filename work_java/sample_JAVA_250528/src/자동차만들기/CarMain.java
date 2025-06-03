package 자동차만들기;

import java.util.Scanner;

public class CarMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while(true) {
            System.out.print("이동 지역 선택 [1]부산 [2]대전 [3]강릉 [4]광주: ");
            int selectArea = sc.nextInt();
            System.out.print("이동할 승객 수 입력 : ");
            int peopleNum = sc.nextInt();
            System.out.print("이동할 차량 선택 [1]스포츠카 [2]승용차 [3]버스 : ");
            int selectCar = sc.nextInt();
            System.out.print("부가 기능 [1]ON [2]OFF :");
            int option = sc.nextInt();
            System.out.print("날씨 [1]맑음 [2]비 [3]눈 :");
            int weather = sc.nextInt();
            sc.nextLine();
            switch (selectArea){
                case 1:
                    selectArea=400;
                    break;
                case 2:
                    selectArea=150;
                    break;
                case 3:
                    selectArea=200;
                    break;
                case 4:
                    selectArea=300;
                    break;
            }

            switch (selectCar) {
                case 1:
                    Car sportCar = new SportsCar("페라리");
                    System.out.print(sportCar.carName+":"+"오디오: ");
                    if(sc.nextLine().equals("On")) ((SportsCar)sportCar).Music();

                    System.out.print(sportCar.carName+":"+"자율주행: ");
                    if(sc.nextLine().equals("On")) ((SportsCar)sportCar).isAutoMode();
                    if(option==1) sportCar.setMode(true);

                    System.out.println("총 비용: "+sportCar.totalCost(selectArea,peopleNum));
                    System.out.println("총 주유 횟수: "+sportCar.fuelCnt(selectArea,peopleNum));
                    System.out.println("총 이동 시간: ");
                    break;


            }
        }
    }



}
