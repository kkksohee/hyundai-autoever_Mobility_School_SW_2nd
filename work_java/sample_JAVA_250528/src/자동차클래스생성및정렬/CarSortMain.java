package 자동차클래스생성및정렬;

import java.util.Set;
import java.util.TreeSet;

public class CarSortMain {
    public static void main(String[] args) {
        Set<CarSort> cars = new TreeSet<>(new SortComparator());
        cars.add(new CarSort(1999, "소나타", 2000));
        cars.add(new CarSort(1988, "프라이드", 700));
        cars.add(new CarSort(2001, "그랜저", 2800));
        cars.add(new CarSort(2012, "싼타페", 3500));
        cars.add(new CarSort(2022, "GV80", 7000));

        for(CarSort car : cars){
            System.out.println(car);
        }
    }

}
