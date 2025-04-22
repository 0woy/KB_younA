package ch09중첩클래스_익명객체.Basic.sec01;

public class InstanceMemeber {
    public static void main(String[] args) {
        A a = new A();
        A.B b = a.new B();
    }
}
