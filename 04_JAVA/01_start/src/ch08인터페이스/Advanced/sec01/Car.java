package ch08인터페이스.Advanced.sec01;

public class Car {
    Tire tire1;
    Tire tire2;

    public Car() {
        this.tire1 = new HankookTire();
        this.tire2 = new HankookTire();
    }

    public void setTire(Tire tire) {
        this.tire1 = tire;
        this.tire2 = tire;
    }

    public void run(){
        tire1.roll();
        tire2.roll();
    }
}
