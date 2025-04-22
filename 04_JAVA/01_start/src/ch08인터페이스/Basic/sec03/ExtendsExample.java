package ch08인터페이스.Basic.sec03;

public class ExtendsExample {
    public static void main(String[] args) {
        InterfaceCImpl impl = new InterfaceCImpl();
        InterfaceA ia = impl;
        ia.methodA();
        System.out.println();

        InterfaceB ib = impl;
        ib.methodB();
        System.out.println();

        InterfaceC ic = impl;
        ic.methodC();
        System.out.println();

        ic.methodA();
        ic.methodB();
        ic.methodC();
    }
}
