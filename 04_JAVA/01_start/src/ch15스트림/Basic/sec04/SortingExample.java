package ch15스트림.Basic.sec04;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortingExample {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("홍길동",30),
                new Student("신용권",10),
                new Student("유미선",20)
        );
        list.stream().sorted().forEach(std -> System.out.println(std.getName()+":"+std.getScore()));
        System.out.println();
        list.stream().sorted(Comparator.reverseOrder()).forEach(std -> System.out.println(std.getName()+":"+std.getScore()));

    }
}
