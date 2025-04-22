package ch09중첩클래스_익명객체.Basic.sec01;

public class A {
    class B {}
    B field = new B();
    A(){
        B b = new B();
    }
    void method(){
        B b = new B();
    }
}
