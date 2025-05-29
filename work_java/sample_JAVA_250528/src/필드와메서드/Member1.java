package 필드와메서드;
//필드: 클래스 내부에 선언된 변수(인스턴스필드, 정적필드, 지역변수)
//메서드: 클래스 내부에 정의된 동작 기능을 수행하는 함수(순수 기능 부분, getter와setter)
//ㄴ1. 기능 목적 2. 단순히 읽고쓰기

//학교명은 고정 학번,이름, 주소 - 학교명 고정했다는건 인스턴스 필드 x
public class Member1 {
    private static String school="가산고"; //정적필드
    private int num; //학번
    private String name; //이름
    private String addr; //주소
    //생성자의 주요 목적: 인스턴스 필드의 초기값을 부여하는 목적
    //ㄴ 기본적으로 클래스 이름과 동일함, 생성자는 반환타입 x
    //: 크래스가 객체로 만들어질 때 자동으로 불려지는 것, 안만들면 기본생성자가 불려짐

    public Member1(){ //생성자는 만들지 않으면 기본 생성자가 자동으로 생성되어 숨어있음
        num =100;
        name = "없음";
        addr  = "없음";
    }
    //매개변수가 있는 생성자, 생성자 오버로딩
    public Member1(int num, String name, String addr){
        this.num=num;
        this.name=name;
        this.addr=addr;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        int test=100;
        this.num = num;
    }
    //정적 메서드: 클래스 생성시 생서되고, 객체와 무관
    public static String getSchool() {
        return school;
    }
    //정적 메서드: 클래스 생성시 생서되고, 객체와 무관
    public static void setSchool(String school) {
        Member1.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
