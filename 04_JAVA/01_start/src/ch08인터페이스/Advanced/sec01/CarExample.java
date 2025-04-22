package ch08인터페이스.Advanced.sec01;

public class CarExample {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.run();

        myCar.setTire(new KumhoTire());
        myCar.run();
    }
}
