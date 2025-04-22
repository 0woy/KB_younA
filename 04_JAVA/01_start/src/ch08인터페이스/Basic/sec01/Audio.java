package ch08인터페이스.Basic.sec01;

public class Audio implements RemoteControl {

    @Override
    public void turnOn() {
        System.out.println("Audio를 켭니다.");
    }
}
