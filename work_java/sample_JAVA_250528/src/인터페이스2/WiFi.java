package 인터페이스2;

public class WiFi implements NetworkAdapter{
    @Override
    public void connect() {
        System.out.println("Wifi에 연결되었습니다.");
    }

    @Override
    public void send(String msg) {
        System.out.println("Wifi>>"+msg);
    }
}
