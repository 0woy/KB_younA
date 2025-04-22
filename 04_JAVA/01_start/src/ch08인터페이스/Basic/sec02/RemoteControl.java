package ch08인터페이스.Basic.sec02;

public interface RemoteControl {
    int MAX_VOLUME = 10;
    int MIM_VOLUME = 0;

    void turnOn();
    void turnOff();
    void setVolume(int volume);
}
