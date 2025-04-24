package ch10라이브러리.Basic.baseModule.sec03;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Member {
    private String id;
    private String name;
    private int age;
}
