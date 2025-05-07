package ch14람다.Basic.sec04;

public class LamdaExample {
    public static void main(String[] args) {
        Person person = new Person();
        person.action((x,y)->{
            double result = x+y;
            return result;
        });

        person.action(LamdaExample::sum);

    }
    public static double sum(double x, double y) {
        return x+y;
    }
}
