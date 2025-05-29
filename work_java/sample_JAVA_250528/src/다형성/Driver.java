package 다형성;

public class Driver {
    String name;
    //생성자
    public Driver(String name){
        this.name= name;
    }
    //메소드
    void drive(Vehicle v){
        System.out.println(name+"의 ");
        v.run(); //Vehicle, 세단, 스포츠카, 등등 뭐가 불려질지 결정 안남
    }
}
