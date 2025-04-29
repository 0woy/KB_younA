package ch12제네릭.Basic.sec03;

public class CarAgency implements Rentable<Car>{
    @Override
    public Car rent(){
        return new Car();
    }
}
