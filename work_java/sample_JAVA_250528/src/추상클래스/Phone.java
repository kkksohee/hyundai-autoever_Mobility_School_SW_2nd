package 추상클래스;

//abstract 키워드 사용하면 인스턴스(객체) 생성이 안됨
public abstract class Phone {
    private String name;
    private boolean isPower;

    public Phone(String name){
        this.name = name;
    }

    public void setPower(boolean power) {
        isPower = power;
        if(isPower){
            System.out.println("Power ON");
        }
        else{
            System.out.println("Poser OFF");
        }
    }
    abstract void call(); //추상 메서드: 자식이 반드시 오버라이딩을 해야함
}
