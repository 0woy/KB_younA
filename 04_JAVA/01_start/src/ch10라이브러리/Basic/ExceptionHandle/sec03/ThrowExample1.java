package ch10라이브러리.Basic.ExceptionHandle.sec03;

public class ThrowExample1 {
    public static void main(String[] args) {
        try {
            findClass();
        }catch (ClassNotFoundException e){
            System.err.println("예외처리: "+e.getMessage());
        }

    }

    public static void findClass() throws ClassNotFoundException {
        Class.forName("java.lang.String2");
    }
}
