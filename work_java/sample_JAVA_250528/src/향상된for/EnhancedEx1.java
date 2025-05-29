package 향상된for;

import java.util.Scanner;

// iterable 객체 순회
//iterable 객체? 정해진 순서가 있는 것, 인덱스 기반

//기존 for문 :
//향상된 for: 시작과 끝을 지정할 수 없음 , 처음부터 끝까지 자동으로 순회, 내부의 값을 변경할 수 없음
public class EnhancedEx1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        배열, 어레이, 링크드 리스트,벡터
        int[] arr = {1,2,3,4,66,77,88,99};
        for(int e : arr){ //arr이라는 배열을 자동 순회 e(element)이라는 뜻에서 함
            e +=100;
            System.out.print(e + " ");
        }
        System.out.println();
        for(int e : arr){ //원본 그대로 나옴
            System.out.print(e + " ");
        }
    }
}
