package 디폴트메소드;
//필드 : 모든 필드는 자동으로 public final static 으로 변환
public interface RemoteControl {
    int MAX_VOLUME = 100; //인터페이스 생성 시 한번 생성되고 변경 불가
    int MIN_VOLUME = 0;
    void turnON(); //abstract 가 자동 추가
    void trunOFF();
    void setVolume(int vol);
    //default 메서드 jdk 8버전 추가, 예외조항
    default void setMute(boolean mute){ //default 구현부 필요
        if(mute)System.out.println("무음 처리 합니다.");
        else System.out.println("무음 해제 합니다.");
    }
    //인터페이스 소속 메서드
    static void changeNewBattery(){
        System.out.println("건전지를 교환 합니다. ");
    }
}
