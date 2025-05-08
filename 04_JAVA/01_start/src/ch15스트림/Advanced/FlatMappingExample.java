package ch15스트림.Advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatMappingExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("this is,java");
        list.add("i am a best developer");

        list.stream()
                .flatMap(str -> Arrays.stream(str.split(" |,")))
                .forEach(System.out::println);

    }
}
