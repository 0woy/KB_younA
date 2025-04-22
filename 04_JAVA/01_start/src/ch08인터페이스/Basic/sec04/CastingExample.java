package ch08인터페이스.Basic.sec04;

public class CastingExample {
    public static void main(String[] args) {
        Vehicle v = new Bus();

        v.run();
        // v.checkFare();

        Bus bus = (Bus) v;
        bus.run();
        bus.checkFare();
    }
}
