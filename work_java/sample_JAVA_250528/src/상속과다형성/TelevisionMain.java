package 상속과다형성;

public class TelevisionMain {
    public static void main(String[] args) {
        ProductTV productTV1 = new ProductTV(false, 11, 20, false);//제품의 공장 초기화 값
        productTV1.setName("소히 티비!");
        productTV1.setVolume(30);
        productTV1.setChannel(20, true); //인터넷기능 켜서 채널설정 안먹힘
        productTV1.viewTV();
    }
}
