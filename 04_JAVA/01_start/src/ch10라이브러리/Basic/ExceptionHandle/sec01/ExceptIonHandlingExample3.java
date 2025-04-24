package ch10라이브러리.Basic.ExceptionHandle.sec01;

public class ExceptIonHandlingExample3 {
    public static void main(String[] args) {
        String [] array = {"100","1oo",null,"200"};
        for (int i = 0; i <= array.length; i++) {
            try {
                int val = Integer.parseInt(array[i]);
                System.out.println("arr[" + i + "]=" + val);
            }catch (NumberFormatException  | NullPointerException e){
                System.err.println(e.getMessage());
            }catch (ArrayIndexOutOfBoundsException e2){
                System.err.println(e2.getMessage());
            }
        }

    }
}
