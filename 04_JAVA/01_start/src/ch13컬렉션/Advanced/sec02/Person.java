package ch13컬렉션.Advanced.sec02;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Person implements Comparable<Person> {
    public String name;
    public int age;


    @Override
    public int compareTo(Person o) {
        return age-o.age;
    }
}
