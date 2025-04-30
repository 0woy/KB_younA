package ch13컬렉션.Basic.sec03;

public class sendSMS implements Command{
    @Override
    public void execute(String to) {
        System.out.println(to+"에게 SMS를 보냅니다.");
    }
}
