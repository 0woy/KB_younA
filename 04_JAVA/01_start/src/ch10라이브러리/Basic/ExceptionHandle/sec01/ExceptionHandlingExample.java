package ch10라이브러리.Basic.ExceptionHandle.sec01;

public class ExceptionHandlingExample {
    public static void printLength(String data){
        try{
            int result = data.length();
            System.out.println("문자 수: "+result);
        }catch(NullPointerException e){
//            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println("프로그램 시작");
        printLength("ThisisJava");
        printLength(null);
        System.out.println("프로그램 종료");
    }
}
