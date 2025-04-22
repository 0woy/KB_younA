package ch07상속.Basic.sec06;

public class SmartPhone extends Phone{
    public SmartPhone(String owner) {
        super(owner);
    }
    void internetSearch(){
        System.out.println("인터넷을 겁색합니다.");
    }

}
