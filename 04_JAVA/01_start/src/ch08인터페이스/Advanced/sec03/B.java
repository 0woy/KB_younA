package ch08인터페이스.Advanced.sec03;

public class B extends A{
    int a =8;

    @Override
    public void disp() {
        a+=5;
        System.out.println("bb: "+a);
    }
}
