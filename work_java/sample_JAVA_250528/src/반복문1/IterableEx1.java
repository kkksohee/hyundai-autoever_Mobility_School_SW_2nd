package 반복문1;
//while (조건식이 참인 동안 반복)

import java.util.Scanner;

public class IterableEx1 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.print("정수 입력:");
        int num =sc.nextInt();
        int sum = 0;
        while(num>0){
            sum += num;
            num--;
        }System.out.println(sum);
        for(int i=1; i<=num; i++){
            sum+=i;
        }System.out.println(sum);
    }
}
