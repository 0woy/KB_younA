package ch13컬렉션.Basic.sec02;

import java.util.*;

public class HashMapExample1 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("박윤아", 85);
        map.put("민정아", 95);
        map.put("김지은", 10000);
        map.put("김두리", 80);
        map.put("커리지", 55);

        System.out.println("총 Entry 수: "+map.size());
        System.out.println();


        String key ="김두리";
        int value = map.get(key);
        System.out.println(key+":"+value);
        System.out.println();

        Set<String> keSet = map.keySet();
        Iterator<String> iter = keSet.iterator();
        while (iter.hasNext()) {
            String k = iter.next();
            int v= map.get(k);
            System.out.println(k+":"+v);
        }

        System.out.println();

        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String,Integer>> entryIter = entrySet.iterator();
        while (entryIter.hasNext()) {
            Map.Entry<String,Integer> entry = entryIter.next();
            String k = entry.getKey();
            int v = entry.getValue();
            System.out.println(k+":"+v);
        }
        System.out.println();

        map.remove("커리지");
        System.out.println("총 Entry 수: "+map.size());
        System.out.println();
    }
}