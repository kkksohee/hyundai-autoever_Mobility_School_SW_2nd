package 에어컨설계;

public class Aircnon extends ProtoAircon {
    boolean smartAircon;
    boolean carryAircon;
    String bettery;

    public Aircnon(){}
    public void setSetTmp(int stmp, boolean isSmartAircon){
        if(isSmartAircon){
            curTmp=20;
            wind=2;
        }
        else{
            if(16< stmp && stmp< 30){
                setTmp=stmp;
            }
            else{
                System.out.println("온도 설정 범위가 아닙니다.");
            }
        }
    }
    public void setSetTmp(boolean isCarryAircon, String bettery){
        if(isCarryAircon){
            System.out.println("베터리: "+bettery);
        }
        else{
            System.out.println("휴대용 에어컨 아님.");
        }
    }
}
