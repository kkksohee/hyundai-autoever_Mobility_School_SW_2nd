package 에어컨설계;

import java.util.Calendar;

public class Aircon_T {
    protected boolean isPower;
    protected int setTemp;
    protected int currTemp;
    protected int windStep;

    public Aircon_T(){
        //평균기온
        int[] monthTemp = {-5, 3, 10, 15, 22, 28, 32, 30, 24, 16, 8, 4};
        //인덱스 개념으로 달이 넘어옴 5월이면 4
        int month = Calendar.getInstance().get(Calendar.MONTH);
        this.currTemp = monthTemp[month]; //현재온도 설정(원래라면 센서에서 읽어오면됨)
        this.setTemp = 24; //에어컨의 초기 셋팅값
        this.windStep = 1;
        this.isPower = false;
    }
    public void powerOn(){
        isPower=true;
        System.out.println("전원이 켜졌습니다.");
    }
    public void powerOff(){
        isPower=false;
        System.out.println("전원이 꺼졌습니다.");
    }
    public void setTemp(int temp){
        this.setTemp = temp;
    }
    public void setWindStep(int step) {
        if (step >= 1 && step <= 3) this.windStep = step;
    }
    public void displayStatus() {
        System.out.println("==== 에어컨 상태 ====");
        System.out.println("전원: " + (isPower ? "ON" : "OFF"));
        System.out.println("현재 온도: " + currTemp);
        System.out.println("설정 온도: " + setTemp);
        System.out.println("바람 세기: " + windStep + "단계");
    }
    public int getCurrTemp() { return currTemp; }
    public int getSetTemp() { return setTemp; }
    public boolean isPowerOn() { return isPower; }
    public int getWindStep() { return windStep; }

    //온도가 바뀔 때 설정온도<현재온도 => 덥다! 온도 내림
    public void simulateTemperatureChange() {
        if (setTemp < currTemp) currTemp--;
        else if (setTemp > currTemp) currTemp++;
    }
}
