package 스퀘어반복;

import java.util.Scanner;

public class SquareEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int cnt=0;
        for(int i=0; i<num*num; i+=num){
            for(int j=1+i; j<=num+i; j++){
                System.out.printf("%d\t",j);
            }System.out.println(" ");
        }

        System.out.print("정수 입력: ");
        int num1 = sc.nextInt();
        for( int i=0; i<=num1*num1;  i++){
            System.out.printf("%4d",i);
            if(i%num1 ==0) System.out.println();
        }
    }
}
