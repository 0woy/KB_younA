package ch15스트림.Basic.sec04;

import java.util.*;

public class OptionalExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        double avg = list.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        System.out.println("평균: "+avg);
    }
}
