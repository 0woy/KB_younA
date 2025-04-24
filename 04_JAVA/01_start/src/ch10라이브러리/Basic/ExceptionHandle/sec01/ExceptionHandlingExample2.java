package ch10라이브러리.Basic.ExceptionHandle.sec01;

public class ExceptionHandlingExample2 {
    public static void main(String[] args) {
        String[]array = {"100","1oo"};
        for(int i=0;i<=array.length;i++){
            try {
                int val = Integer.parseInt(array[i]);
                System.out.println("array["+i+"]:"+val);
            }catch (ArrayIndexOutOfBoundsException e){
                System.err.println(e.getMessage());
            }catch (NumberFormatException e){
                System.err.println(e.getMessage());
            }
        }
    }
}
