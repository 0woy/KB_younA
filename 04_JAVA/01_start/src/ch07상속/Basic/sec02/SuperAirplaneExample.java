package ch07상속.Basic.sec02;

public class SuperAirplaneExample {
    public static void main(String[] args) {
        SupersonicAirplane sa =  new SupersonicAirplane();
        sa.takeOff();
        sa.fly();
        sa.flyMode=SupersonicAirplane.SUPERSONIC;
        sa.fly();
        sa.flyMode = SupersonicAirplane.NORMAL;
        sa.fly();
        sa.land();
    }
}
