package ch09중첩클래스_익명객체.Advanced.sec03;

public class AnonymousChild {
    public static void main(String[] args) {
        Car car = new Car();
        car.run1();
        car.run2();
        car.run3(new Tire(){
            @Override
            public void roll() {
                System.out.println("익명 객체 Tire 3이 굴러갑니다.");
            }
        });
    }
}
