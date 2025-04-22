package ch07상속.Basic.sec06;

public class PhoneExample {
    public static void main(String[] args) {
        // 추상 클래스는 객체를 생성할 수 없음
        //  Phone phone = new Phone();

        SmartPhone smartPhone= new SmartPhone("홍길동");
        smartPhone.turnOn();
        smartPhone.internetSearch();
        smartPhone.turnOff();

    }
}
