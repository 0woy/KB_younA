package ch15스트림.Advanced;

import java.util.ArrayList;
import java.util.List;

public class MapExample {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("박윤아",90));
        list.add(new Student("김두리",51));
        list.add(new Student("김지은",100));

        list.stream().mapToInt(Student::getScore).forEach(System.out::println);
    }
}
