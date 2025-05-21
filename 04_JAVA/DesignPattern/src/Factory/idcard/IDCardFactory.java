package Factory.idcard;

import Factory.framework.Factory;
import Factory.framework.Product;

public class IDCardFactory extends Factory {
    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product p) {
        System.out.println(p+"을 등록했습니다.");
    }
}
