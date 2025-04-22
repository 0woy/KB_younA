package ch08인터페이스.Basic.sec02;

public class MultiInterfacImplExample {
    public static void main(String[] args) {
        RemoteControl rc =new SmartTelevision();
        rc.turnOn();
        rc.turnOff();

        Searchable searchable = new SmartTelevision();
        searchable.search("https://www.baidu.com/");
    }
}
