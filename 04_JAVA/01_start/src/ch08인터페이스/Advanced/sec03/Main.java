package ch08인터페이스.Advanced.sec03;

public class Main {
    public static void main(String[] args) {
        A ab= new B();

        B b = new B();
        A a = new A();
        ab.disp();
        a.disp();
        b.disp();

    }
}
