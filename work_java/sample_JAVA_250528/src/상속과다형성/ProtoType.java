package 상속과다형성;

public class ProtoType {
    boolean isPower; //전원 onoff
    int channel;     //채널
    int volume;      //볼륨


//    public ProtoType(){}

    public ProtoType(boolean isPower, int cnl, int vol){
        this.isPower = isPower; //this: 자신의 객체 가르킴
        channel = cnl;
        volume =vol;
    }
    //setter의 역할: 내부의 인스턴스값이 정해진 범위에서 설정되도록 해야 함
    public void setChannel(int cnl){
        if(cnl > 0 && cnl <1000){ //1~999번까지
            channel= cnl;
        }else{
            System.out.println("채널 설정 범위가 아닙니다.");
        }
    }
    public void setPower(boolean power){
        isPower=power;
    }
}
