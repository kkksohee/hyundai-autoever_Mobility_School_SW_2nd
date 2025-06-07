package Comparator;

import java.util.TreeSet;

public class CompMain {
    public static void main(String[] args) {
        TreeSet<CarComp> set = new TreeSet<>();
        set.add(new CarComp("코나",2020, "흰색"));
        set.add(new CarComp("스포티지",2020, "흰색"));
        set.add(new CarComp("그랜저",2016, "검정색"));
        set.add(new CarComp("산타페",2018, "회색"));
        set.add(new CarComp("GV80",2023, "회색"));
        set.add(new CarComp("GV80",2023, "흰색")); //색깔 정렬조건을 안넣어줬기 때문

        for(CarComp car: set){
            System.out.println(car.name + ":"+car.year);
        }
    }
}
