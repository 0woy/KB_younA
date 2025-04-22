package ch06클래스;

class Calculator{

    public Calculator(){}

    public int plus(int a, int b){
        return a+b;
    }

    public double divide(int a, int b){
        return (double)a/b;
    }
     public double areaRectangle(int width){
        return width*width;
     }

     public double areaRectangle(int width, int height){
        return width*height;
     }

    public void powerOn(){
        System.out.println("전원을 켭니다.");
    }
    public void powerOff(){
        System.out.println("전원을 끕니다.");
    }
}
class Calculator2{
    static double pi = 3.14159;
    static int plus(int x, int y) {
        return x + y;
    }
    static int minus(int x, int y) {
        return x - y;
    }
}
public class CalculatorExample {
    public static void main(String[] args) {
        Calculator myCalc = new Calculator();
        myCalc.powerOn();

        int result1 = myCalc.plus(5,6);
        System.out.println("result1 : " + result1);

        int x=10;
        int y=4;
        double result2=myCalc.divide(x,y);
        System.out.println("result2 : " + result2);

        myCalc.powerOff();

        System.out.println();
        double res1 = myCalc.areaRectangle(10);
        double res2 = myCalc.areaRectangle(10,20);
        System.out.println("정사각형 넓이="+res1);
        System.out.println("직사각형 넓이="+res2);

        res1 =10*10*Calculator2.pi;//
        res2 =Calculator2.plus (10,5);
        int res3 =Calculator2.minus(10,5);

        System.out.println("res1 = " + res1);
        System.out.println("res3 = " + (int)res2);
        System.out.println("res3 = " + res3);
    }
}
