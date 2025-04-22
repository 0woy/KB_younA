package ch07상속.Basic.sec03;

public class ChildExample {
    public static void main(String[] args) {
        Parent parent = new Child();

        parent.field1 = "data1";
        parent.method1();
        parent.method2();

        // 부모 타입으로 형변환 됐으므로 자식 필드 & 메소드 접근 불가
        // parent.field2 = "data2";
        // parent.method3();


        Child child = (Child) parent;
        child.field2 = "data2";
        child.method3();
    }

}
