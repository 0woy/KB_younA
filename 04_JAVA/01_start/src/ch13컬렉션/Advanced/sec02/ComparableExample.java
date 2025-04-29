package ch13컬렉션.Advanced.sec02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableExample {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("홍길동",35));
        list.add(new Person("김자바",25));
        list.add(new Person("박지원",31));

        Collections.sort(list);

        for(Person person : list) {
            System.out.println(person.name+" "+person.age);
        }
    }
}
