package ch08인터페이스.Basic.sec03;

public class InterfaceCImpl implements InterfaceC {

    @Override
    public void methodC() {
        System.out.println("InterfaceCImpl methodC");
    }

    @Override
    public void methodA() {
        System.out.println("InterfaceCImpl methodA");
    }

    @Override
    public void methodB() {
        System.out.println("InterfaceCImpl methodB");
    }
}
