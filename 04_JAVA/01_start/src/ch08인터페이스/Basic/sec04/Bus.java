package ch08인터페이스.Basic.sec04;

public class Bus implements Vehicle {

    @Override
    public void run() {
        System.out.println("버스가 달립니다.");
    }

    public void checkFare(){
        System.out.println("승차 요금을 체크합니다.");
    }
}
