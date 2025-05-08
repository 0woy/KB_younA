package ch15스트림.Basic.sec02;

import java.util.ArrayList;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        for(int i=0;i<5;i++){
            Product p = new Product(i,"상품"+i, "멋쟁이 회사", (int)(10000 * Math.random()));
            list.add(p);
        }
//        list.stream().forEach(p -> System.out.println(p.toString()));
        list.stream().forEach(System.out::println);

    }
}
