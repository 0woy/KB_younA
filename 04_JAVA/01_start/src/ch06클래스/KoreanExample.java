package ch06클래스;

public class KoreanExample {
    static class Korean{
        String nation = "대한민국";
        String name;
        String ssn;

        public Korean( String name, String ssn) {
            this.name = name;
            this.ssn = ssn;
        }
        public String print(String ins) {
            return ins+".nation : "+nation +"\n"+
                    ins+".name : "+name+"\n"+
                    ins+".ssn : "+ssn+"\n";
        }
    }
    public static void main(String[] args) {
        Korean k1 = new Korean("박자바", "011225-1234567");
        Korean k2 = new Korean("김자바", "930525-0654321");
        System.out.println(k1.print("k1"));
        System.out.println(k2.print("k2"));

    }
}
