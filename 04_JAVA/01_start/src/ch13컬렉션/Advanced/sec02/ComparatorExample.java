package ch13컬렉션.Advanced.sec02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorExample {
    public static void main(String[] args) {
        ArrayList<Fruit> fruits = new ArrayList<Fruit>();
        fruits.add(new Fruit("포도",3000));
        fruits.add(new Fruit("수박",10000));
        fruits.add(new Fruit("딸기",6000));

        FruitCompartor fruitCompartor = new FruitCompartor();
//        Collections.sort(fruits, fruitCompartor);

        Collections.sort(fruits, new Comparator<Fruit>() {
            @Override
            public int compare(Fruit o1, Fruit o2) {
                return o1.price - o2.price;
            }
        });

        for(Fruit fruit : fruits){
            System.out.println(fruit.name+" "+fruit.price);
        }
    }
}
