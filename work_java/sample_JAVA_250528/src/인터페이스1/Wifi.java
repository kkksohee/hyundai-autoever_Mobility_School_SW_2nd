package 인터페이스1;

public class Wifi implements NetworkAdapter{
    String company;
    public Wifi(String company){
        this.company=company;
    }
    @Override
    public void connect() {
        System.out.println(company+"Wifi에 연결되었습니다.");

    }
}

class FiveG implements NetworkAdapter{
    String company;
    public FiveG(String company){
        this.company=company;
    }
    @Override
    public void connect() {
        System.out.println(company+"5G에 연결되었습니다.");

    }
}
class Lte implements NetworkAdapter{
    String company;
    public Lte(String company){
        this.company=company;
    }
    @Override
    public void connect() {
        System.out.println(company+"LTE에 연결되었습니다.");

    }
}