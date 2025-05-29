package 접근제한자;

public class Parent {
    public String name; //default 상태
    public String money;
//    public String addr;
    private String addr;
    //생성자
    public Parent(){
        name="이건희";
        money="100억";
        addr="서울시 강남구 삼성동";
    }
        public String getAddr(){
        return this.addr;
    }
}
