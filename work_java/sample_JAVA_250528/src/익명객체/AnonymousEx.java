package 익명객체;

public class AnonymousEx{
    public static void main(String[] args) {
        RemoteControl rc = new RemoteControl() {
            int volume;
            @Override
            public void turnOn() {
                System.out.println("플레이스테이션5 켭니다.");
            }

            @Override
            public void turnOff() {
                System.out.println("플레이스테이션5 끕니다.");
            }

            @Override
            public void setVolume(int volume) {
                if(volume>MAX_VOLUME) this.volume=MAX_VOLUME;
                else if(volume<MIN_VOLUME) this.volume=MIN_VOLUME;
                else this.volume = volume;
                System.out.println("현재 볼륨 : " + this.volume);
            }

            @Override
            public void getInfo() {
                System.out.println("플레이스테이션5 입니다.");
                System.out.println("현재 볼륨 : " + volume);
            }
        };
        rc.turnOn();
        rc.setVolume(12);
        rc.getInfo();

    }
}