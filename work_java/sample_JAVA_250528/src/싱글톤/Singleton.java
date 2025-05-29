package 싱글톤;
// 싱글톤:프로그램 전체에서 단 하나의 객체만 만들도록 보장함
//1. 메모리 절약 용도
public class Singleton {
    String name;
    int id;
    //내부에서 이미 싱글톤 객체를 만듬 근데 static을 걸었으니 한번만 만듬
    private static Singleton singleton = new Singleton();
    private Singleton(){ //외부에서 접근하지 못하도록 생성자 private = 생성자를 숨김
        name = "곰돌이 사육사";
        id=100;

    }
    //클래스 메서드 : 미리 생성된 싱글톤 객체의 주소를 반환
    static Singleton getSingleton(){
        return singleton;
    }

}
