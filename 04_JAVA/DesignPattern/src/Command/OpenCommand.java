package Command;

import java.io.IOException;

public class OpenCommand implements Command {
    @Override
    public void execute(){
        System.out.println("============");
        System.out.println("Open Command");
        System.out.println("============");
        System.out.println();
    }
}
