package ch08인터페이스.Basic.sec02;

public class Television implements RemoteControl{
    private int volume;

    public Television() {
        turnOn();
        setVolume(5);
        turnOff();
    }

    @Override
    public void turnOn() {
        System.out.println("TV를 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("TV를 끕니다.");
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
        System.out.println("현재 TV 볼륨 : "+volume);
    }
}
