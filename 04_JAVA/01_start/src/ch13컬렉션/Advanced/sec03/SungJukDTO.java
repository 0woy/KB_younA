package ch13컬렉션.Advanced.sec03;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class SungJukDTO {
    private int no;
    private String name;
    private int kor;
    private int eng;
    private int math;
    private int tot;
    private double avg;

    public SungJukDTO(int no, String name, int kor, int eng, int math) {
        this.no = no;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public void calc(){
        tot = kor+eng+math;
        avg = tot/3.0;
    }

    @Override
    public String toString() {
        return "SungJukDTO{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", kor=" + kor +
                ", eng=" + eng +
                ", math=" + math +
                ", tot=" + tot +
                ", avg=" + String.format("%.2f", avg) +
                '}';
    }
}
