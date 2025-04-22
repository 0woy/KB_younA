package Adapter.adapter01;

public class Main {
    public static void main(String[] args) {
        Print p= new PrintBanner("Hello");
        p.printWeak();
        p.printStrong();

        print(new PrintBanner("Hello Banner"));
    }
    
    // 고정된 사용자 코드
    public static void print(Print p){
        p.printWeak();
        p.printStrong();
    }
}
