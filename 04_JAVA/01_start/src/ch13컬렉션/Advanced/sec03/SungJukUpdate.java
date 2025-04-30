package ch13컬렉션.Advanced.sec03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SungJukUpdate implements SungJuk{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    @Override
    public void execute(ArrayList<SungJukDTO> list) {
        int i=0;
        try {
            System.out.print("번호 입력: ");
            int no = Integer.parseInt(br.readLine());
            for (; i < list.size(); i++) {
                if (list.get(i).getNo() == no) {
                    break;
                }
            }
            if(i==list.size()){
                System.out.println("잘못된 번호 입니다.");
                return;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        SungJukDTO std = list.get(i);
        try {
            System.out.print("수정할 이름 입력: ");
            std.setName(br.readLine());

            System.out.print("수정할 국어 입력: ");
            std.setKor(Integer.parseInt(br.readLine()));

            System.out.print("수정할 영어 입력: ");
            std.setEng(Integer.parseInt(br.readLine()));

            System.out.print("수정할 수학 입력: ");
            std.setMath(Integer.parseInt(br.readLine()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        std.calc();
        list.set(i, std);
        System.out.println("수정하였습니다.");
    }
}
