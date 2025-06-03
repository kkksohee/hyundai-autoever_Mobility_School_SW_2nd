package Math클래스;
//클래스 메서드 이므로 객체생성 없이 사용
public class MathMain {
    public static void main(String[] args) {
        //random() 메소드는 0.0이상 1.0미만의 임의의 실수 생성
        //1 ~45 사이의 임의의 정수 값 생성
        for(int i=0; i<6; i++){
            int val = (int)(Math.random()*45) + 1;
            System.out.println(val);
        }
        //ceil(): 소수점 이하가 있으면 무조건 올림
        System.out.println(Math.ceil(10.0));
        System.out.println(Math.ceil(10.1));
        System.out.println(Math.ceil(10.00000234));
        //floor(): 소수점 이하를 무조건 날림
        System.out.println(Math.floor(10.0));
        System.out.println(Math.floor(10.8));
        System.out.println(Math.floor(10.03112201));
        //round(): 반올림
        System.out.println(Math.round(10.0));
        System.out.println(Math.round(10.499));
        System.out.println(Math.round(10.9));
        int x = 10;
        int y= 20;
        System.out.println(Math.max(x,y));

    }
}
