package 조건문;

import java.util.Scanner;

public class conditionex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt(); //공백기준
        int min = sc.nextInt();
        int calc = hour *60 +min; //분으로 환산
        if(calc <45){
            calc = 24 *60+min; //45미만에 대한 처리
        }calc -=45;
//        if(hour == 0){
//            hour = 23;
//        }
//        else{
//            hour -=1;
//        }
//        if(min<45){
//            min += 60-45;
//        }
//        else{
//            min -=45;
//        }
        System.out.println((calc/60)+" "+ (calc %60));
//        System.out.println(hour+" "+min);

    }
}
