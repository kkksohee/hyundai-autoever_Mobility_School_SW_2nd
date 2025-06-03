package Arrays클래스;
//배열을 다루기 위한 다양한 메소드 포함
import javax.swing.text.Style;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ArraysMain {
    public static void main(String[] args) {
//        Integer[] arr = {5,4,3,7,9,8,2,1};
//        Arrays.sort(arr, Collections.reverseOrder());
//        for(int e : arr) {
//            System.out.print(e + " ");
//        }
//        System.out.println();

        //이름의 길이 순으로 정렬하고 길이가 같은 경우 사전순으로 정렬하기
        String[] fruits = {"Kiwi", "Orange", "Apple", "Banana", "Melon",
                "Mango", "Watermelon", "Cherry", "Plum", "Peach"};
        //정렬조건->익명의 함수로
//        Comparator: 두개의 값/객체를 받아서 정렬 할지 말지 결정
        Arrays.sort(fruits, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() >o2.length()) return 1;//양수는 정렬조건(sort알고리즘이 해줌)
                else {
                    if(o1.length()==o2.length()){
                        return o1.compareTo(o2); //사전순 정렬
                    }return -1; //음수면 현상태 유지
                }

            }

        });
        System.out.println(Arrays.toString(fruits));
    }

}
