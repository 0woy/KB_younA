package ch10라이브러리.Basic.baseModule.sec06;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataExample {
    public static void main(String[] args) {
        Date now = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yy.MM.dd HH:mm:ss");
        String strNow = sdf.format(now);
        System.out.println(strNow);
    }
}
