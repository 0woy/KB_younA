package ch13컬렉션.Basic.sec03;

public class sendKakaotalk implements Command{
    @Override
    public void execute(String to) {
        System.out.println(to+"에게 카카오톡을 보냅니다.");
    }
}
