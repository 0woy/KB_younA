package ch07상속.Basic.sec02;

public class CalculatorExample {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Computer computer = new Computer();

        System.out.println(calc.areaCircle(10));
        System.out.println(computer.areaCircle(10));
    }
}
