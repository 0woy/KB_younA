package ch10라이브러리;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BirthDay {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String date = br.readLine().replaceAll("[^0-9]", "");
        Date birthDay = new Date();

        birthDay.setYear(birthDay.getYear() + 1900);

    }
}
