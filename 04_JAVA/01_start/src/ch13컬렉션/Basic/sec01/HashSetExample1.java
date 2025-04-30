package ch13컬렉션.Basic.sec01;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample1 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("JAVA");
        set.add("JDBC");
        set.add("Servlet/JSP");
        set.add("JAVA");
        set.add("MyBatis");

        int size = set.size();
        System.out.println("총 객체 수: "+size);


    }
}
