package ch15스트림.Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(
                "this is a java book",
                "Lamda Expressions",
                "Java8 supports lamda expressions");
        list.stream()
                .filter(str -> str.toLowerCase().contains("java"))
                .forEach(System.out::println);
    }
}
