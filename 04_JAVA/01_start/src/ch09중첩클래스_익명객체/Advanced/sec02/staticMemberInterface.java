package ch09중첩클래스_익명객체.Advanced.sec02;

import java.awt.event.ActionListener;

public class staticMemberInterface {
    public static void main(String[] args) {
        Button btnOk = new Button();
        class okListener implements Button.ClickListener{
            @Override
            public void onClick() {
                System.out.println("OK 버튼을 클릭했습니다.");
            }
        }

        btnOk.setClickListener(new okListener());
//        btnOk.setClickListener(new Button.ClickListener() {
//
//            @Override
//            public void onClick() {
//                System.out.println("OK 버튼을 클릭했습니다.");
//            }
//        });

        btnOk.click();
    }
}
