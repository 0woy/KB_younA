package ch08인터페이스.Basic.sec02;

public class Audio implements RemoteControl {
    private int volume;

    public Audio() {
        turnOn();
        setVolume(5);
        turnOff();
    }

    @Override
    public void turnOn() {
        System.out.println("Audio를 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("Audio를 끕니다.");
    }

    @Override
    public void setVolume(int volume) {
        if(volume > MAX_VOLUME){
            volume = MAX_VOLUME;
        }else if(volume < MIM_VOLUME){
            volume = MIM_VOLUME;
        }else{
            this.volume = volume;
        }
        System.out.println("현재 Audio 볼륨 : "+volume);

    }
}
