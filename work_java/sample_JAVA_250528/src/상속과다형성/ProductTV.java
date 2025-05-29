package 상속과다형성;

public class ProductTV extends ProtoType{
    String name; //티비 이름
    boolean isInternet; //인터넷 기능

    //생성자 오버로딩을 해야 됨.
    //부모의 생성자를 부르고 내 생성자에 값을 넣어줌
    public ProductTV(boolean isPower, int cnl, int vol, boolean isInternet) {
        super(isPower, cnl, vol); //부모의 생성자 호출
        this.isInternet = isInternet;
        name="LG";
    }
    public void setName(String name){
        this.name=name;
    }
    //부모가 안만든 기능 만들기
    public void setVolume(int vol){
        if(vol >=0 && vol <=100) {
            volume=vol;
            System.out.println("볼륨을 "+volume+"으로 변경 하였습니다.");
        }
        else{
            System.out.println("볼륨 설정 범위가 아닙니다.");
        }
    }

    //내가 신규로 만들었냐, 부모가 메소드를가지고 있었냐 확인하는 것
    //부모것도 있음. 동적 바인딩임 동작될 때 결정이 나니까
    @Override //오버라이딩 성립 여부를 문법적으로 체크 해주는 에노테이션
    public void setChannel(int cnl){
        if(cnl > 0 && cnl <2000){ //1~1999번까지
            channel= cnl;
            System.out.println("볼륨을 "+channel+"으로 변경 하였습니다.");
        }else{
            System.out.println("채널 설정 범위가 아닙니다.");
        }
    }
    //메서드 오버로딩: 매개변수의 갯수와 타입으로 구분하는 것
    public void setChannel(int cnl, boolean isInternet){
        if(isInternet) {
            System.out.println("인터넷 모드 입니다.");
            this.isInternet = true;
        }else{ //인터넷 모드로 들어가면 채널 설정이 안되니까, 인터넷 기능 없으면 그냥 채널 설정 되도록
            this.isInternet = false;
            if(cnl > 0 && cnl <2000){ //1~1999번까지
                channel= cnl;
                System.out.println("볼륨을 "+channel+"으로 변경 하였습니다.");
            }else{
                System.out.println("채널 설정 범위가 아닙니다.");
            }
        }
    }
    void viewTV(){
        System.out.println("이름: "+name);
        System.out.println("전원: "+isPower);
        System.out.println("채널: "+channel);
        System.out.println("볼륨: "+volume);
        System.out.println("인터넷 모드: "+isInternet);
    }


}
