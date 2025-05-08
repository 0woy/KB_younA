package ch15스트림.Basic.sec01;

import java.util.Arrays;
import java.util.List;

public class StreamPipeLineExample {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("홍길동",10),
                new Student("김두리",20),
                new Student("박윤아",30)
        );

         double result = list.stream()
                .mapToInt(std -> std.getScore())
                .average()
                 .getAsDouble();
        System.out.println("평균 점수: "+result);

    }
}
