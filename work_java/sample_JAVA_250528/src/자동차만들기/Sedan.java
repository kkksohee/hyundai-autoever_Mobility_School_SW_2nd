package 자동차만들기;

public class Sedan extends Car implements Audio,AirCon{
    boolean isTurbo;

    Sedan(String name){
        fuelCost = 12;
        speed=200;
        oilTank=45;
        seatNum=4;
        this.carName = name;
    }
    @Override
    public void Music() {
        System.out.println("오디오가 켜졌습니다.");
        System.out.println("Like Jennie Jennie Jennie~");
    }

    @Override
    public void turnOn() {
        System.out.println("에어컨이 켜졌습니다.");
    }

    @Override
    void setMode(boolean isOn) {
        if(isOn){
            System.out.println("부가기능이 켜졌습니다.");
            seatNum +=1;
        }

    }
}
