package ch09중첩클래스_익명객체.Basic.sec02;

public class A2 {
    static class B {
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
}
