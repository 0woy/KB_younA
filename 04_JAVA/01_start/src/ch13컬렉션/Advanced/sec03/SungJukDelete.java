package ch13컬렉션.Advanced.sec03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SungJukDelete implements SungJuk {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    @Override
    public void execute(ArrayList<SungJukDTO> list) {
        int total =0;
        try {
            System.out.print("삭제할 입력: ");
            String name = br.readLine();
            int i = 0;
            for (; i < list.size(); i++) {
                SungJukDTO sj = list.get(i);
                if(sj.getName().equals(name)) {
                    list.remove(i);
                    total ++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(total >0) {
            System.out.println(total+"건의 항목을 삭제하였습니다.");
        }else{
            System.out.println("회원 정보가 없습니다.");
        }
    }
}
