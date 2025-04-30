package ch13컬렉션.Advanced.sec03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SungJukService {
    private ArrayList<SungJukDTO> list = new ArrayList<>();
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final String board = """
            1. 입력
            2. 출력
            3. 수정
            4. 삭제
            5. 정렬
            6.끝
            메뉴 번호: """;
    SungJuk[] command = new SungJuk[]{
            new SungJukInsert(),
            new SungJukPrint(),
            new SungJukUpdate(),
            new SungJukDelete(),
            new SungJukSort()
    };

    public void menu(){
        while(true){
            System.out.print(board);
            try{
                int cmd = Integer.parseInt(br.readLine());
                if(cmd<1 || cmd>6){
                    System.out.println("1~6번 중에 선택하세요.");
                    continue;
                }
                if(cmd == 6){
                    break;
                }
                command[cmd-1].execute(list);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
