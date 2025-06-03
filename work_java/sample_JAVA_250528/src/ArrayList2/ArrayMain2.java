package ArrayList2;

import java.util.ArrayList;
import java.util.List;

public class ArrayMain2 {
    public static void main(String[] args) {
        List<Menu> menuList = new ArrayList<>();
        menuList.add(new Menu("아메리카노",2000,"coffee","그냥커피",true));
        menuList.add(new Menu("카페모카",4500,"coffee","달달한커피",true));
        menuList.add(new Menu("카페라떼",4000,"coffee","우유커피",true));

        for(Menu menu:menuList){
            System.out.println(menu);
        }
    }


}
