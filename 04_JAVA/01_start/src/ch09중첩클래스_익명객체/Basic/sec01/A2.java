package ch09중첩클래스_익명객체.Basic.sec01;

public class A2 {
    class B {
        int field1 = 1;
        static int field2 = 2;
        
        B(){
            System.out.println("B-생성자");
        }
        void method1(){
            System.out.println("B-method1");
        }
        static void method2(){
            System.out.println("B-method2");
        }
    }
    void useB(){
        B b= new B();
        System.out.println(b.field1);
        b.method1();

        System.out.println(B.field2);
        B.method2();
    }
}
