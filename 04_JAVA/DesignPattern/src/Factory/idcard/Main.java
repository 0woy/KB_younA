package Factory.idcard;

import Factory.framework.Factory;
import Factory.framework.Product;

public class Main {
    public static void main(String[] args) {
         Factory factory = new IDCardFactory();

         Product card1 = factory.create("0woy");
         Product card2 = factory.create("duri");
         Product card3 = factory.create("JE");
        System.out.println();
         card1.use();
         card2.use();
         card3.use();
    }
}
