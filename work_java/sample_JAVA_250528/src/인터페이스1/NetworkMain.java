package 인터페이스1;

import java.util.Scanner;

public class NetworkMain {
    public static void main(String[] args) {
        NetworkAdapter adapter = null;// 인터페이스 참조변수에 초기값 null
        Scanner sc = new Scanner(System.in);
        System.out.print("연결 할 네트워크를 선택하세요 [1]Wifi [2]5G [3]LTE");
        int choice =sc.nextInt();
        switch (choice){
            case 1:
                adapter = new Wifi("KT megapass");
                adapter.connect();
                break;
            case 2:
                adapter = new FiveG("SK");
                adapter.connect();
                break;
            case 3:
                adapter = new Lte("LG");
                adapter.connect();
                break;
            default:
                System.out.println("네트워크 선택이 잘못 됨");
        }
    }
}
