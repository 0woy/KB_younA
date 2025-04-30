package ch13컬렉션.Advanced.sec03;

import java.util.ArrayList;

public class SungJukPrint implements SungJuk{

    @Override
    public void execute(ArrayList<SungJukDTO> list) {
        StringBuilder sb = new StringBuilder();
        System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
        for(SungJukDTO std : list){
           sb.append(std.toString()).append("\n");
        }
        System.out.println(sb);
    }
}
