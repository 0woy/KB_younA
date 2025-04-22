package ch09중첩클래스_익명객체.Basic.sec02;

public class staticMember2 {
    public static void main(String[] args) {
        A2.B b = new A2.B();
        System.out.println(b.field1);
        b.method1();

        System.out.println(b.field2);
        b.method2();
    }
}
