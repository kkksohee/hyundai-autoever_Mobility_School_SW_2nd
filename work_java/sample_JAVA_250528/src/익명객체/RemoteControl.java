package 익명객체;

public interface RemoteControl {
    final static int MAX_VOLUME =10;
    int MIN_VOLUME =0;
    void turnOn();
    void turnOff();
    void setVolume(int volume);
    void getInfo();
}
