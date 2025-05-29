package 출력;
//자바는 표준 입출력클래스를 사용해서 콘솔에서 입력과 출력을 담당
//System.in : 표준 입력
//System.out : 표준 출력(버퍼에 한번 저장하고 출력,출력을 넘길 수 있음)
//System.err : 오류 출력(바로 출력, 출력 넘길 수 x)

//서식지정자 : %d, %ld, %f, %.2f, %2d, %s, %c , %%
//이스케이프시퀀스 :  \n, \r, \t, \b, \\

public class printClass {
    public static void main(String[] args) {
//        name안에 장원영이 없음 참조타입이니까
        String name = "장원영";
        String addr = "서울시 금천구 가산동";
        char gender = 'M'; //내부적으로는 아스키코드값(정수)로
        int age = 26;
        int kor = 99;
        int eng = 40, mat= 30;
        double avg = 0.0;

        //자바스타일(print, println(줄바꿈o)
//        System.out.println("=".repeat(count:8)+ "Java Style"+"=".repeat(count:8));
//        System.out.println("이름: "+name);
//        System.out.println("주소:"+addr);
//        System.out.println("성별"+(gender =='M'? "남성":"여성"));
//        System.out.println("나이"+age);
//        System.out.println("총점:" +(kor+eng+mat));
//        System.out.println("평균:"+((double)(kor+eng+mat)/3));
//        System.out.printf("평균 : %.2f\n",(kor+eng+mat)/3);

    }
}
