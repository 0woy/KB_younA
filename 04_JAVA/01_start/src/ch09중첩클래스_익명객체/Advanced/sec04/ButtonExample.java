package ch09중첩클래스_익명객체.Advanced.sec04;

public class ButtonExample {
    public static void main(String[] args) {
        Button btnOk = new Button();
        btnOk.setClickListener(new Button.ClickListener() {

            @Override
            public void onClick() {
                System.out.println("Ok 버튼을 클릭했습니다.");
            }
        });
        btnOk.click();
        Button btnCancel = new Button();
        btnCancel.setClickListener(new Button.ClickListener() {
            @Override
            public void onClick() {
                System.out.println("Cancle 버튼을 클릭했습니다.");
            }
        });
        btnCancel.click();
    }
}
