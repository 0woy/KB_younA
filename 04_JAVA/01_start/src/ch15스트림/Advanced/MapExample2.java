package ch15스트림.Advanced;

import java.util.Arrays;

public class MapExample2 {
    public static void main(String[] args) {
        int [] intArray = {1,2,3,4,5};


        Arrays.stream(intArray).mapToDouble(i ->(double)i).forEach(System.out::println);
        System.out.println();
        Arrays.stream(intArray).forEach(System.out::println);
    }
}
