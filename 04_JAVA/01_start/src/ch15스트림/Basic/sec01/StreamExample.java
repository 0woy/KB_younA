package ch15스트림.Basic.sec01;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        Set<String> set=new HashSet<>();
        set.add("홍길동");
        set.add("김두리");
        set.add("박윤아");
        Stream<String> stream = set.stream();
        stream.forEach(str -> System.out.println(str));
//        stream.forEach(System.out::println);

    }
}
