package ch15스트림.Practice;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q7 {
    public static void main(String[] args) {
        List<Member> list = Arrays.asList(
                new Member("홍길동", "개발자"),
                new Member("신용권", "디자이너"),
                new Member("김자바", "개발자")
        );
        List<Member> dev = list.stream()
                .filter(v -> v.getJob().equals("개발자"))
                .toList();

        dev.stream().forEach(v-> System.out.println(v.getName()));
    }
    @AllArgsConstructor
    @Getter
    static class Member{
        String name;
        String job;
    }
}
