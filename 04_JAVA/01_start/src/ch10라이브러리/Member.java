package ch10라이브러리;

import lombok.Data;
import lombok.NonNull;

//@NoArgsConstructor
//@AllArgsConstructor
@Data
public class Member {
    private String id;
    @NonNull
    private String name;
    private int age;
}
