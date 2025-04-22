package ch09중첩클래스_익명객체.Basic.sec04;

public class Home {
    private RemoteControl rc = new RemoteControl() {
        @Override
        public void turnOn() {
            System.out.println("TV를 켭니다.");
        }

        @Override
        public void turnOff() {
            System.out.println("TV를 끕니다.");
        }
    };
    public void use1(){
        rc.turnOn();
        rc.turnOff();
    }
}
