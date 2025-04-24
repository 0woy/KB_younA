package ch10라이브러리.Basic.baseModule.sec05;

import java.util.StringTokenizer;

public class StringTokenizerExample {
    public static void main(String[] args) {
        String data1 = "홍길동&이수홍,박연수";
        String [] arr1 = data1.split("&|,");
        for(String str : arr1) {
            System.out.println(str+" ");
        }
        System.out.println();
        String data2 = "홍길동/이수홍/박연수";
        StringTokenizer st = new StringTokenizer(data2,"/");
        while(st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
}
