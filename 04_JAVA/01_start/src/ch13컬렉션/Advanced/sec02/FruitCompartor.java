package ch13컬렉션.Advanced.sec02;

import java.util.Comparator;

public class FruitCompartor implements Comparator<Fruit> {
    @Override
    public int compare(Fruit o1, Fruit o2) {
        return o1.price-o2.price;
    }
}
