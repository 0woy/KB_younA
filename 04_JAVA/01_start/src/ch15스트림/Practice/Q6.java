package ch15스트림.Practice;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class Q6 {
    public static void main(String[] args) {
        List<Member> list = Arrays.asList(
                new Member("홍길동", 30),
                new Member("신용권", 40),
                new Member("깁자바", 26)
        );
        double avg =
                list.stream().mapToDouble(Member::getAge).average().getAsDouble();
        System.out.println(avg);

    }
    @AllArgsConstructor
    @Getter
    static class Member{
        String name;
        int age;
    }
}
