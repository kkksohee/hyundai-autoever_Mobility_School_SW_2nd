package 추상클래스;

public class abstractMain {
    public static void main(String[] args) {
        //부모 클래스의 참조 변수에 자식 객체를 대입->업캐스팅
        Phone smartPhone = new SmartPhone("iPone 16 Pro");
        smartPhone.setPower(true);
        smartPhone.call();
        ((SmartPhone)smartPhone).internet(); //강제로


    }
}
