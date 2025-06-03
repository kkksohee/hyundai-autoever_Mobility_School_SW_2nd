package 자동차만들기;

public class SportsCar extends Car implements Audio,AutoDrive{
    boolean isTurbo;

    SportsCar(String name){
        fuelCost = 8;
        speed=250;
        oilTank=30;
        seatNum=2;
        this.carName = name;
    }
    @Override
    public void Music() {
        System.out.println("오디오가 켜졌습니다.");
        System.out.println("Like Jennie Jennie Jennie~");
    }

    @Override
    public void isAutoMode() {
        System.out.println("자율 주행모드가 켜졌습니다.");
        System.out.println("저만 믿으세욧~!");
    }

    @Override
    void setMode(boolean isOn) {
        if(isOn){
            System.out.println("부가기능이 켜졌습니다.");
            System.out.println("속도를 올리겠습니다!!! ");
            speed=300;
        }

    }
}
