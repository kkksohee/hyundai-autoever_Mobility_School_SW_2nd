package Comparator;

import java.util.Comparator;

public class CarComp implements Comparable<CarComp> {
    String name; //자동차 이름
    int year;    //연식
    String color; //색상

    public CarComp(String name, int year, String color) {
        this.name = name;
        this.year = year;
        this.color = color;
    }

    @Override
    public int compareTo(CarComp o) {
        if(this.year == o.year){
            //사전순 정렬
            //1 : 뒤의 값이 사전순으로 뒤(정렬필요)
            //return this.name.compareTo(o.name); //여기서 0이 return되어서 Gv80한개 빼버림
            //color 값도 비교하도록 수정
            int rst = this.name.compareTo(o.name);
            if(rst != 0) return rst;
            else{
                return this.color.compareTo(o.color);
            }
        }else if(this.year < o.year){
            return -1; //정렬 필요 x
        }else{
            return 1; //정렬 필요, 오름차순 정렬
        }//return 0 이면 중복이라고 체크 -> 빼버림
    }

}
