package 필드와메서드;

import 회원정보실습.Member;

public class Oop1 {
    public static void main(String[] args) {
        Member1 member1 = new Member1();
        member1.setNum(100);
        member1.setName("장원영");
        member1.setAddr("인천시");
        Member1 member2 = new Member1(200, "안유진","대전시");

        System.out.println(member1.getName());
        System.out.println(member2.getAddr());
        System.out.println(Member1.getSchool());

    }
}
