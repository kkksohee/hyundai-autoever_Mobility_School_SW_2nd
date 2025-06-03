package Wrapper클래스;

public class WrapperMain {
    public static void main(String[] args) {
        //    int age =100; //일반 변수
        Age age = new Age();
        age.age = 100; //이게 Wrapper 클래스
    }

}
class Age{
    int age; //이게 Wrapper 클래스
}
