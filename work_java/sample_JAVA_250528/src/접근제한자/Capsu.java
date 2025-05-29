package 접근제한자;

public class Capsu {
    public static void main(String[] args) {
        Child child =new Child();
        child.money = "10억";
        System.out.println(child.getName());
        System.out.println(child.getMoney());
        System.out.println(child.getAddr());
    }
}
