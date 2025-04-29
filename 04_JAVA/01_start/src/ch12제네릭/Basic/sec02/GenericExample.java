package ch12제네릭.Basic.sec02;

public class GenericExample {
    public static void main(String[] args) {
        Product<Tv, String> product = new Product<>();
        product.setKind(new Tv());
        product.setModel("스마트Tv");

        Tv tv = product.getKind();
        String tvModel = product.getModel();

        Product<Car, String> product2 = new Product<>();
        product2.setKind(new Car());
        product2.setModel("SUV 자동차");

        Car car = product2.getKind();
        String carModel = product2.getModel();
    }
}
