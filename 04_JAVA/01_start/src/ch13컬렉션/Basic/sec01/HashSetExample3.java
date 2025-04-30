package ch13컬렉션.Basic.sec01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample3 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("JAVA");
        set.add("JDBC");
        set.add("Servlet/JSP");
        set.add("JAVA");
        set.add("MyBatis");

        // Iterator 패턴으로 순회
        Iterator<String> iter = set.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        System.out.println();
        
        // 향상된 for문으로 순회
        for(String str: set){
            System.out.println(str);
        }

    }
}
