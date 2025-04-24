package Template;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<AbstractDisplay> d1 = List.of(new CharDisplay('H'), new StringDisplay("Hello World"));
        for(AbstractDisplay d : d1) {
            d.display();
        }

    }

}
