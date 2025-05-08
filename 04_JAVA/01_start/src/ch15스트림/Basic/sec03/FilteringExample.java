package ch15스트림.Basic.sec03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(
                "홍길동",
                "신용권",
                "김자바",
                "신용권",
                "신민철"
        );
        list.stream().distinct().forEach(System.out::println);
        System.out.println();
        list.stream().filter(s -> s.startsWith("신")).forEach(System.out::println);
        System.out.println();
        list.stream().distinct().filter(s->s.startsWith("신")).forEach(System.out::println);
    }
}
