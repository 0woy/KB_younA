package ch14람다.Basic.sec03;

public class LamdaExample {
    public static void main(String[] args) {
        Person person = new Person(); 
        person.action((name, work)->{
            System.out.println(name+"이 "+work+"을 합니다." );
        });
        person.action((name, work)->{
            System.out.println(name+"이 "+work+"을 하지 않습니다." );
        });

        person.action2((content -> System.out.println(content+"라고 말합니다.")));
        person.action2((content -> System.out.println(content+"라고 외칩니다.")));
        
    }
}
