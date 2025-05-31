package 에어컨설계_테스트;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AirconMain {
    public static void main(String[] args) throws InterruptedException{
        Scanner sc = new Scanner(System.in);
        System.out.print("에어컨 종류 선택 (1: 기본 / 2: 스마트 / 3: 휴대용) :");
        int type=sc.nextInt();
        //수정 : 업캐스팅
        Aircon ac = null;

        switch (type){
            case 1:
                ac =new Aircon();
                //수정: 전원 켜야지!
                ac.powerOn();
                System.out.print("설정 온도 입력 :");
                ac.setTemp(sc.nextInt());
                System.out.print("바람 세기 입력(1~3) :");
                ac.setWind(sc.nextInt());
                break;
            case 2:
                ac = new SmartAircon();
                ac.powerOn();
                while(true){
                    System.out.print("스마트 에어컨 자동 모드 설정 (true / false) : ");
                    try{
                        boolean auto =sc.nextBoolean();
                        ((SmartAircon)ac).autoSetting(auto);
                        break;

                    }catch (InputMismatchException e) {
                        System.out.println("설정된 값만 입력하세요!");
                        sc.nextLine();//입력 버퍼 지우기

                    }
                }

                System.out.print("설정 온도 입력 :");
                ac.setTemp(sc.nextInt());
                System.out.print("바람 세기 입력(1~3) :");
                ac.setWind(sc.nextInt());
                break;
            case 3:
                ac = new PortableAirCon();
                ac.powerOn();
                System.out.print("설정 온도 입력 :");
                ac.setTemp(sc.nextInt());
                System.out.print("바람 세기 입력(1~3) :");
                ac.setWind(sc.nextInt());
                break;
        }
        int escape = 0;
        int second;
        //바람 세기에 따라 변경되는 온도 변화 시간
        switch(ac.getWindSet()){
            case 1:
                second =60;
                break;
            case 2:
                second= 30;
                break;
            case 3:
                second = 20;
                break;
            default:
                second =60;
                System.out.println("바람 세기 잘못 입력! 기본 값으로 동작합니다.");
                break;
        }
        while(ac.getPower()){
            Thread.sleep(1000);
            escape++;

            //바람세기에 따라 설정된 시간이 흘렀다면 온도 변화
            if(second <=escape){
                ac.simulationTemp();
                ac.printStatus();//현재 상태 출력
                if(ac instanceof PortableAirCon)
                    ((PortableAirCon)ac).displayBattery(); //베터리 잔량 출력
                escape=0;
            }
            if(ac.getCurTemp()==ac.getSetTemp()){
                System.out.println("✅ 설정 온도 도달. 안녕히계세욧!");
                ac.powerOff();
            }

        }

    }
}
