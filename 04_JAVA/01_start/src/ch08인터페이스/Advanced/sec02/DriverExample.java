package ch08인터페이스.Advanced.sec02;

public class DriverExample {
    public static void main(String[] args) {
        Driver driver = new Driver();
        Bus bus = new Bus();
        Taxi taxi = new Taxi();

        //driver.drive(bus);
        //driver.drive(taxi);
        ride(taxi);
        ride(bus);
    }

    public static void ride(Vehicle vehicle) {
        if(vehicle instanceof Bus) {
            ((Bus) vehicle).checkFare();
        }
        vehicle.run();
    }
}
