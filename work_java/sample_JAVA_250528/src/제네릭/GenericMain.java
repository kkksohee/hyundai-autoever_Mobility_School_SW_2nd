package 제네릭;

public class GenericMain {
    public static void main(String[] args) {
        GenericPrint<Powder> powderPrint = new GenericPrint<>();
        powderPrint.setMaterial(new Powder());
        //println()은 객체가 들어오면 자동으로 toString()을 호출해서 문자열로 바꾼 뒤 출력
        System.out.println(powderPrint);
        //getMaterial()은 제네릭 타입 T(Powder)를 반환
        powderPrint.getMaterial().doPrinting();
        //아래 코드와 같은 의미
        Powder p = powderPrint.getMaterial();
        p.doPrinting();

        GenericPrint<Plastic> plasticPrint = new GenericPrint<>();
        plasticPrint.setMaterial(new Plastic());
        System.out.println(plasticPrint);

        //Material로 상속받은애만 사용할 수 있기 때문에 에러
        //GenericPrint<Water> waterGenericPrint = new GenericPrint<>();
    }
}

