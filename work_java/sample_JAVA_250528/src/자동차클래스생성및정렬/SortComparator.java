package 자동차클래스생성및정렬;

import java.util.Comparator;
//연식 내림차순
//이름 오름차순
//가격 오름차순
public class SortComparator implements Comparator<CarSort> {
    @Override
    public int compare(CarSort o1, CarSort o2) {
        if(o1.year>o2.year) return -1;
        else if(o1.year == o2.year){
            if(o1.name.length()>o2.name.length()) return 1;
            else return -1;
        }else return 1;
    }
}
