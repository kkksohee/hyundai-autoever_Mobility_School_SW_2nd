package 다형성;
//탈것의 대표적인 부모 클래스
public class Vehicle {

    public void run(){
        System.out.println("차량이 달립니다.");
    }
}
//여러개의 클래스 만들 때
class SportsCar extends Vehicle{
    @Override
    public void run(){
        System.out.println("파나메라가 달립니다.");
    }
}
class Sedan extends Vehicle{
    @Override
    public void run(){
        System.out.println("그랜저가 달립니다.");
    }
}
class Suv extends Vehicle{
    @Override
    public void run(){
        System.out.println("GV80이 달립니다.");
    }
}
