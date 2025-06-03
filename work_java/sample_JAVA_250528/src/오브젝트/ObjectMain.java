package 오브젝트;
//java.lang.Object : 모든 클래스에 최상위 부모 클래스

public class ObjectMain {
    public static void main(String[] args) {
        Student student1 = new Student();
        //클래스명@16진수해시코드, 오버라이딩후 사용하는 경우가 많음
        System.out.println(student1.toString()); //객체의 문자열 표현 반환
        System.out.println(student1);
        Student student2 = new Student();

        //equals():두 객체가 같은지 비교, 해시코드로 비교
        System.out.println(student1.equals(student2));
        student1 =student2;//주소 대입
        System.out.println(student1.equals(student2)); //두 객체가 같은지 비교, 기본동작은 주소값 비교

    }
}

//extends Object가 숨어있음
class Student extends Object{

}