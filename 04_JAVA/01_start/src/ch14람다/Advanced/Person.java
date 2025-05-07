package ch14람다.Advanced;

public class Person {

    public Member getMember(Creatable1 creatable1) {
        String id ="winter";
        Member member = creatable1.create( id );
        return member;
    }

    public Member getMember2(Creatable2 creatable2) {
        String id ="winter";
        String name ="한겨울";
        Member member = creatable2.create(id,name);
        return member;
    }

    public void action(Calcuable calcuable) {
        double result = calcuable.calcuate(10,4);
        System.out.println("결과: "+result);
    }
}
