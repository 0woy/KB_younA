package ch15스트림.Basic.sec03;

import java.util.stream.IntStream;

public class IntStreamExample {
    public static int sum;
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 100).forEach(a -> sum+=a);
        System.out.println("총합: "+sum);
    }
}
