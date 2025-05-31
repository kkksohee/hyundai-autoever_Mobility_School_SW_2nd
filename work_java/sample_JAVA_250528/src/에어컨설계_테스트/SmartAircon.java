package 에어컨설계_테스트;

import 에어컨설계.Aircon_T;

public class SmartAircon extends Aircon {
    private boolean autoMode =false;

    //수정 : automode onoff 확인 메소드, 세팅 메소드
    public boolean isAutoMode(boolean autoMode) {
        return autoMode;
    }
    public void autoSetting(boolean onOff){
        this.autoMode = onOff;
        if(autoMode){
            this.setTemp = 20;
            this.windSet = 2;
            System.out.println("자동 설정 모드 on (20도/ 2단계)");
        }else{
            System.out.println("자동 설정 모드 off");
        }
    }
    @Override
    public void setTemp(int setTemp){
        if(!autoMode) this.setTemp = setTemp;
        else{
            System.out.println("제가 알아서 해드릴게욧!");
        }
    }
    @Override
    public void setWind(int windSet) {
        if (!autoMode) {
            this.windSet = windSet;
        } else {
            System.out.println("제가 알아서 해드릴게욧!");
        }
    }
}
