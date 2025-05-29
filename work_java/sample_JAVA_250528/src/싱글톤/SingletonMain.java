package 싱글톤;

public class SingletonMain {
    public static void main(String[] args) {
        Sutent student1 = new Sutent();
        Sutent student2 = new Sutent();
        student1.setInfo("안유진",21);
        student2.viewInfo();
    }
}
