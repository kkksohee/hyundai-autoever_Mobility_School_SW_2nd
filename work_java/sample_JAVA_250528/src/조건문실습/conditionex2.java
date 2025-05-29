package 조건문실습;

import java.util.Scanner;

//세자리 정수를 입력 받아 가장 큰 수 출력
//768 => 8
public class conditionex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int a,b,c;
        a=num/100;
        b=(num/10)%10;
        c=num%10;

        String num1 = sc.next();
        int a1 = num1.charAt(0)-'0';
        int b1 = num1.charAt(1)-'0';
        int c1 = num1.charAt(2)-'0';
        System.out.println(a1);
        System.out.println(b1);
        System.out.println(c1);

        if(a1>b1){
            if(a1>c1) System.out.println(a1);
            else System.out.println(c1);
        }
        else{
            if(b1>c1) System.out.println(b1);
            else System.out.println(c1);
        }

        if(a>b){
            if(a>c) System.out.println(a);
            else System.out.println(c);
        }
        else{
            if(b>c) System.out.println(b);
            else System.out.println(c);
        }


    }
}
