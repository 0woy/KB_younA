package ch15스트림.Basic.sec04;

import java.util.ArrayList;
import java.util.List;

public class SortingExample2 {
    public static void main(String[] args) {
        List<NonStudent> list = new ArrayList<>();
        list.add(new NonStudent("홍길동", 30));
        list.add(new NonStudent("신용권", 10));
        list.add(new NonStudent("유미선", 20));

        list.stream()
                .sorted((s1, s2) -> Integer.compare(s2.getScore(), s1.getScore()))
                .forEach(std -> System.out.println(std.getName()+":"+std.getScore()));

        System.out.println();
        list.stream()
                .sorted((o1,o2)-> Integer.compare(o2.getScore(), o1.getScore()))
                .forEach(std -> System.out.println(std.getName()+":"+std.getScore()));
    }
}
