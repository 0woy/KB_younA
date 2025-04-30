package ch13컬렉션.Advanced.sec03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class SungJukSort implements SungJuk{
    String board= """ 
            *****************
            1. 총점으로 내림차순
            2. 이름으로 오름차순
            3. 이전 메뉴
            *****************
            정렬 선택: """;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void execute(ArrayList<SungJukDTO> list) {
        System.out.println(board);
        try {
            int no = Integer.parseInt(br.readLine());
            switch (no) {
                case 1: list.sort((a,b)-> b.getTot()-a.getTot()); break;
                case 2: list.sort(new Comparator<SungJukDTO>() {
                    @Override
                    public int compare(SungJukDTO o1, SungJukDTO o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                }); break;
                case 3: return;
            }
        } catch (IOException e) {

        }
    }
}
