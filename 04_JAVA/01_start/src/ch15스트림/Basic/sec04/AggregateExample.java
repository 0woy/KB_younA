package ch15스트림.Basic.sec04;

import java.util.Arrays;
import java.util.stream.IntStream;

public class AggregateExample {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};

        long count = Arrays.stream(arr)
                .filter(a -> a%2==0)
                .count();
        System.out.println("2의 배수 개수: "+count);

        count = Arrays.stream(arr)
                .filter(a -> a%2==0)
                .sum();
        System.out.println("2의 배수의 합: "+count);

        System.out.println("2의 배수의 평균: "+
                Arrays.stream(arr)
                .filter(e -> e%2==0)
                .average().getAsDouble());

        System.out.println("최대값: "+
                Arrays.stream(arr).filter(e -> e%2==0).max().getAsInt());
        System.out.println("최솟값: "+
                Arrays.stream(arr).filter(e -> e%2==0).min().getAsInt());
        System.out.println("첫 번째 3의 배수: "+
                Arrays.stream(arr).filter(e -> e%3==0).findFirst().getAsInt());
    }
}
