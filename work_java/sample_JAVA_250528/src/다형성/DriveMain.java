package 다형성;

import java.util.Scanner;

public class DriveMain {
    public static void main(String[] args) {
        Driver driver = new Driver("소히");
        SportsCar ferrari = new SportsCar();
        Sedan g80  = new Sedan();
        Suv x6 = new Suv();

        Scanner sc = new Scanner(System.in);
        System.out.print("운전하고 싶은 차 선택 [1]ferrari [2] G80 [3] x6:");
        int choice = sc.nextInt();
        switch (choice){
            case 1: driver.drive(ferrari); break;
            case 2: driver.drive(g80); break;
            case 3: driver.drive(x6); break;
            default:
        }

    }
}
