package Command;

import java.io.IOException;

public class PrintCommand implements Command {
    @Override
    public void execute(){
        System.out.println("============");
        System.out.println("Print Command");
        System.out.println("============");
        System.out.println();
    }
}
