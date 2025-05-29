package 에어컨설계;

public class ProtoAircon {
    boolean isPower;
    int curTmp;
    int setTmp;
    int wind;

    public ProtoAircon(){

    }
    public void setPower(boolean isPower){
        this.isPower=isPower;

    }
    public void getCurTmp(int ctmp){
        curTmp=ctmp;
        System.out.println("현재 온도: "+curTmp);
    }
    public void setSetTmp(int stmp){
        if(16< stmp && stmp< 30){
            setTmp=stmp;
        }
        else{
            System.out.println("온도 설정 범위가 아닙니다.");
        }
    }
    public void setWind(int wind){
        if(1<=wind && wind<=3){
            this.wind = wind;
        }else {
            System.out.println("바람 세기 설정 범위 초과");
        }
    }
    public void PrntSetting(){
        System.out.println("전원 표시: "+isPower);
        System.out.println("설정 온도: "+setTmp);
        System.out.println("현재 온도: "+curTmp);
        System.out.println("바람 세기: "+wind);
    }
}
