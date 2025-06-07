package 자동차클래스생성및정렬;

public class CarSort {
    int year;
    String name;
    int price;

    public CarSort(int year, String name, int price) {
        this.year = year;
        this.name = name;
        this.price = price;
    }
    @Override
    public String toString(){
        return "차동차 명: "+name +"연식: "+year+"가격: "+price;
    }
}
