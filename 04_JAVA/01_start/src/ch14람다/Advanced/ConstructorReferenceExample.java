package ch14람다.Advanced;

public class ConstructorReferenceExample {
    public static void main(String[] args) {
        Person person = new Person();
        Member m1=  person.getMember(Member::new);
        System.out.println(m1);
        System.out.println();

        Member m2=  person.getMember2(Member::new);
        System.out.println(m2);
    }
}
