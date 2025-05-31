package 에어컨설계_테스트;

import java.util.Calendar;

//기본 에어컨
public class Aircon {
    //필드
    protected boolean isPower;
    protected int curTemp;
    protected int setTemp;
    protected int windSet;

    // 생성자
    public Aircon(){
        int[] monthTemp={-5, 3, 10, 15, 22, 28, 32, 30,
        24, 16, 8, 4};
        //수정 : 현재 온도 = 월별 평균 온도
        int month = Calendar.getInstance().get(Calendar.MONTH);
        this.curTemp = monthTemp[month];
        this.isPower = false;
        this.setTemp = 24;
        this.windSet=1;
    }
    public void powerOn(){
        this.isPower = true;
        System.out.println("전원이 켜졌습니다.");
    }
    public void powerOff(){
        this.isPower = false;
        System.out.println("전원이 꺼집니다..");
    }
    public void setTemp(int setTemp){
        this.setTemp = setTemp;
    }
    public void setWind(int windSet){
        if(1<=windSet && windSet<=3) this.windSet = windSet;
    }
    //수정: 전체 출력 구문 미 작성
    public void printStatus(){
        System.out.println("==== 에어컨 상태 ====");
        System.out.println("전원: "+ (isPower? "ON": "OFF"));
        System.out.println("현재 온도: "+curTemp);
        System.out.println("설정 온도: "+setTemp);
        System.out.println("바람 세기: "+windSet +"단계");
    }
    public int getCurTemp(){return curTemp;}
    public int getSetTemp(){return setTemp;}
    public int getWindSet(){return windSet;}
    //수정 power도 get 필요
    public boolean getPower(){return isPower;}

    //수정: 같은 온도는 변경x -> else if 사용
    public void simulationTemp(){
        if(curTemp <setTemp) curTemp++;
        else if(curTemp > setTemp) curTemp--;
    }
}
