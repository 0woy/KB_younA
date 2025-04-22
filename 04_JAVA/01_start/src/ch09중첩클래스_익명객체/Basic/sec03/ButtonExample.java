package ch09중첩클래스_익명객체.Basic.sec03;

public class ButtonExample {
    public static void main(String[] args) {
        class OkBtn implements Button.ClickListener{
            @Override
            public void onClick() {
                System.out.println("Ok button clicked");
            }
        }
    }
}
