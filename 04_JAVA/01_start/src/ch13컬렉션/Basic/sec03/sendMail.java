package ch13컬렉션.Basic.sec03;

public class sendMail implements Command{
    @Override
    public void execute(String to) {
        System.out.println(to+"에게 메일을 보냅니다.");
    }
}
