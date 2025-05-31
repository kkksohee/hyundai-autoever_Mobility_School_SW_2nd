package 에어컨설계_테스트;

import java.awt.*;

public class PortableAirCon extends Aircon{
    private int battery =100;

    @Override
    public void simulationTemp(){
        if(battery > 0){
            super.simulationTemp();
            battery--;
        }else{
            System.out.println("충전 필요 !! 잠들겠습니다");
        }
    }
    public void displayBattery(){
        System.out.println("베터리 잔량: "+ battery+"%");
    }
    public int getBattery(){
        return battery;
    }
}
