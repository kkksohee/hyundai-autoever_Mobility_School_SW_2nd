package 인터페이스2;

import java.lang.foreign.PaddingLayout;
import java.util.Scanner;

public class CocoaMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NetworkAdapter adapter=null;

        System.out.println("네트워크 선택 : [1]Wifi [2]5G");
        int choice = sc.nextInt();

        adapter = (choice==1)? new WiFi() : new FiveG();
        CocoaTok cocoaTok = new CocoaTok("IVE", adapter);
        cocoaTok.writeMsg("오늘은 덥네요 건강 조심~~!");
        cocoaTok.send();
    }
}
