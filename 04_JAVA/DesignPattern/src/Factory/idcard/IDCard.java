package Factory.idcard;

import Factory.framework.Product;

public class IDCard extends Product {
    private String owner;

    public IDCard(String owner) {
        System.out.println(owner+"의 카드를 만듦");
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println(this +"을 사용");
    }

    @Override
    public String toString() {
        return "[IDCard: " + owner+"]";
    }
}
