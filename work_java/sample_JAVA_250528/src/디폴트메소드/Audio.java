package 디폴트메소드;

public class Audio implements RemoteControl{
    private int volume;
    @Override
    public void turnON() {
        System.out.println("오디오를 켭니다.");
    }

    @Override
    public void trunOFF() {
        System.out.println("오디오를 끕니다.");
    }

    @Override
    public void setVolume(int vol) {
        if(vol>RemoteControl.MAX_VOLUME){
            this.volume= RemoteControl.MAX_VOLUME;
        }else if(vol<RemoteControl.MIN_VOLUME) {
            this.volume = RemoteControl.MIN_VOLUME;
        }else{
            this.volume=vol;
        }
    }
}
