package 에어컨설계;
//1. 기본에어컨 만들기
//- 전원 on/off
//-현재 온도 표시 기능
//-설정 온도 표시 기능
//- 바람 세기 (1/2/3단)
//- 현재 상태 출력기능 ..(전원표시, 현재온도, 설정온도, 바람세기)
//2. 스마트 에어컨
//- 자동 설정 기능 on: 자동으로 20도 설정, 바람 2단계
//3. 휴대용 에어컨
//- 베터리 표시 기능 추가

import java.util.Scanner;

//InterruptedException sleep() 1ms 단위 => 1초마다 잠
//슬립들어가는 순간에(잠자는 동안) 걸리면 예외처리 하지 않겠다는 뜻
public class AirconMain {
    public static void main(String[] args) throws InterruptedException {
//        Aircnon aircon1 = new Aircnon();
//        Aircnon aircon2 = new Aircnon();
//
//        aircon1.setPower(true);
//        aircon1.setSetTmp(21);
//        aircon1.setSetTmp(21,true);
//        aircon1.PrntSetting();
        Scanner sc = new Scanner(System.in);
        System.out.print("에어컨 종류 선택 (1: 기본 / 2: 스마트 / 3: 휴대용): ");
        int type = sc.nextInt();

        Aircon_T ac = null; //

        switch(type){
            case 1:
                ac = new Aircon_T();
                ac.powerOn();
                System.out.println("설정온도 입력: ");
                ac.setTemp(sc.nextInt());
                System.out.println("바람세기 입력(1~3): ");
                ac.setWindStep(sc.nextInt());
                break;
            case 2:
                ac = new SmartAirCon_T();
                ac.powerOn();
                System.out.println("스마트 자동모드 설정(true, false): ");
                boolean auto = sc.nextBoolean();
                if(!auto){
                    System.out.println("설정온도 입력: ");
                    ac.setTemp(sc.nextInt());
                    System.out.println("바람세기 입력(1~3): ");
                    ac.setWindStep(sc.nextInt());
                }
                break;
            case 3:
                ac = new PortableAirCon_T();
                ac.powerOn();
                System.out.println("설정온도 입력: ");
                ac.setTemp(sc.nextInt());
                System.out.println("바람세기 입력(1~3): ");
                ac.setWindStep(sc.nextInt());
                break;
        }
        while(ac.isPowerOn()){
            Thread.sleep(1000);
            ac.simulateTemperatureChange();
            ac.displayStatus();
            if (ac instanceof PortableAirCon_T portable) {
                portable.displayBattery();
            }
            if (ac.getCurrTemp() == ac.getSetTemp()) {
                System.out.println("✅ 설정 온도 도달. 에어컨 종료.");
                ac.powerOff();
            }
        }
    }
}
