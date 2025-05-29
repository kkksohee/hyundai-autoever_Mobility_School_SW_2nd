package 회원정보실습;

import java.util.Scanner;

public class Member {
    private String name;
    private int age;
    private char gender;
    private int job;
    private final Scanner sc = new Scanner(System.in);

//    생성자를 생략하면 기본 생성자가 숨어있음
//    메서드는 누구나 입력가능해야 하기 때문에
    public void setName(){
        System.out.print("이름을 입력하세요: ");
        //this: 내부의 객체를 바라보고 있는 것, 반환할 필요가 없음
        name = sc.nextLine(); //name에 숨어있는 것 this(C언어의 구조체 포인터 같은 것
    }
    public void setAge(){
        while(true){
            System.out.print("나이를 입력하세요: ");
            age=sc.nextInt();
            if(0<=age && age<200) return;
        }
    }
    public void setGender(){
        while(true){
            System.out.print("성별을 입력하세요 : ");
            gender = sc.next().charAt(0);
            switch (gender){
                case 'M': case 'm': case 'F': case 'f': return;
            }
        }
    }
    public int getGenderType(){
        if(gender =='M'||gender=='m') return 1;
        return 2;
    }
    public void setJob(){
        while(true){
            System.out.print("직업을 입력하세요 : ");
            job = sc.nextInt();
            if(0<job && job<5) return;
        }
    }
    public void getMember(){
//        배열 자체의 내부 값을 사용하는게 아니라 단순히 출력용이니까 final => 주소만 고정이래
//        앞에 ""비운이유 :
        final String[] genderStr = {"", "남성","여성"};
        final String[] jobStr = {"","학생","회사원","주부","무직"};
        System.out.println("=".repeat(8) + "회원정보" + "=".repeat(9));
        System.out.println("이름: "+name );
        System.out.println("나이: "+age );
        System.out.println("성별: "+genderStr[getGenderType()] );
        System.out.println("직업:" + jobStr[job]);


    }
}
