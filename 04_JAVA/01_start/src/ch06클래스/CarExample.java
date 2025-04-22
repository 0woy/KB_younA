package ch06클래스;

class Car1{
    String model;
    boolean start;
    int speed;
}
class Car2{
    String model;
    String color;
    int speed;

    public Car2(String model, String color, int speed) {
        this.model = model;
        this.color = color;
        this.speed = speed;
    }
}
class Car3{
    String company ="현대자동차";
    String model;
    String color;
    int maxSpeed;

    public Car3() {
    }

    public Car3(String model) {
        this(model,null,0);
        // this.model = model;
    }

    public Car3(String model, String color) {
        this(model, color, 0);
        // this.model = model;
        // this.color = color;
    }

    public Car3(String model, String color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public void getInfo(String ins) {
        StringBuilder sb= new StringBuilder();
        sb.append(ins+".company : "+company+"\n");
        if(model!=null){sb.append(ins+".model : "+model+"\n");}
        if(color!=null){sb.append(ins+".color : "+color+"\n");}
        if(maxSpeed>0){sb.append(ins+".speed : "+maxSpeed+"\n");}
        System.out.println(sb);
    }

}
class Car4{
    int gas;
    void setGas(int gas) {
        this.gas = gas;
    }

    boolean isLeftGas(){
        if(gas == 0){
            System.out.println("gas가 없습니다.");
        }else{
            System.out.println("gas가 있습니다.");
        }
        return gas > 0;
    }

    void run() {
        while (true) {
            if (gas > 0) {
                System.out.println("달립니다. (gas잔량: " + gas+")");
            } else {
                System.out.println("멈춥니다. (gas잔량: " + gas+")");
                return;
            }
            gas--;
        }
    }
}
class Car5{
    String model;
    int speed;

    public Car5(String model) {
        this.model = model;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void run(){
        System.out.println(model+"가 달립니다. (시속: "+speed+"km/h)");
    }
}
class Car6{
    private int speed;
    private boolean stop;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed > 0 ? speed : 0;
    }

    public void setStop(boolean stop) {
        if(stop){
            this.speed = 0;
        }
    }
    public boolean isStop() {
        return stop;
    }
}
public class CarExample {
    public static void main(String[] args) {
        Car1 c1 = new Car1();
        System.out.println(c1.model+" "+c1.start+" "+c1.speed);

        Car2 c2 = new Car2("그랜저", "검정",250);

        Car3 car1 = new Car3();
        Car3 car2 = new Car3("자가용");
        Car3 car3 = new Car3("자가용", "빨강");
        Car3 car4 = new Car3("택시", "검정",200);
        car1.getInfo("car1");
        car2.getInfo("car2");
        car3.getInfo("car3");
        car4.getInfo("car4");


        Car4 gasCar = new Car4();
        gasCar.setGas(5);
        if(gasCar.isLeftGas()){
            System.out.println("출발합니다.");
            gasCar.run();
        }
        System.out.println("gas를 주입하세요");
        System.out.println();


        Car5 modelCar = new Car5("페라리");
        modelCar.setSpeed(10000);
        modelCar.run();
        System.out.println();

        Car6 speedCar = new Car6();
        speedCar.setSpeed(-50);
        System.out.println("현재 속도: "+speedCar.getSpeed());
        speedCar.setSpeed(60);
        System.out.println("현재 속도: "+speedCar.getSpeed());
        speedCar.setStop(true);
        System.out.println("현재 속도: "+speedCar.getSpeed());

    }
}
