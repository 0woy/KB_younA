package ch13컬렉션.Advanced.sec03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SungJukInsert implements SungJuk {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private boolean isPresent(int no, ArrayList<SungJukDTO> list) {
        for(SungJukDTO dto : list){
            if(dto.getNo() == no){return true;}
        }
        return false;
    }
    @Override
    public void execute(ArrayList<SungJukDTO> list){
        try {
            System.out.print("번호 입력: ");
            int no = Integer.parseInt(br.readLine());
            if(isPresent(no, list)){
                System.out.println("중복된 번호로 삽입할 수 없습니다.");
                return;
            }
            System.out.print("이름 입력: ");
            String name = br.readLine();
            System.out.print("국어 입력: ");
            int kor = Integer.parseInt(br.readLine());
            System.out.print("영어 입력: ");
            int eng = Integer.parseInt(br.readLine());
            System.out.print("수학 입력: ");
            int math = Integer.parseInt(br.readLine());

            SungJukDTO std = new SungJukDTO(no, name, kor, eng, math);
            std.calc();
            list.add(std);
        }catch (IOException e){
            System.err.println("입력 중 오류 발생");
        }
    }
}
//언니 이거 풀고 나 알려줘 ~~~
// System.out.println("윤아 언니 문제 꼭 풀어서 나 알려줘~~-성빈");