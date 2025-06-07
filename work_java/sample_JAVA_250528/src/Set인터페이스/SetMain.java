package Set인터페이스;

import java.util.HashSet;

public class SetMain {
    public static void main(String[] args) {
//        HashSet<String> set = new HashSet<>();
//        set.add("안유진");
//        set.add("장원영");
//        set.add("정상기");
//        set.add("김소희");
//        set.add(new String("정상기")); //hashCode(), equals()둘 다 오버라이딩 되어 있음
//
//        for(String e : set){
//            System.out.println(e+" ");
//        }
        HashSet<Member> set = new HashSet<>();
        set.add(new Member(1001,"유나"));
        set.add(new Member(1002,"닝닝"));
        set.add(new Member(1002,"채원")); //id가 같아서 생략됨
        set.add(new Member(1003,"지젤"));

        for(Member e : set){
            System.out.println(e);
        }
    }
}
//오버라이딩 하지 않으면 동등객체 라고 판별 x -> 다른객체 -> 중복이라고 보지 않음
class Member {
    int id;
    String name;
    @Override
    public int hashCode(){
        return id;//내부의 id값으로 중복여부를 체크하기 위해서
    }
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Member){//다운캐스팅
            Member member = (Member) obj;
            if(this.id == member.id) return true;
            else return false;
        }return false;
    }
    public Member(int id, String name){
        this.id = id;
        this.name = name;
    }
    @Override
    public String toString(){
        return "아이디: "+id+ "\n"+"이름: "+ name;
    }
}
