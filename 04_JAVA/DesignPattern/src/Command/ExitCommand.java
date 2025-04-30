package Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExitCommand implements Command {
    @Override
    public void execute() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("종료할까요? (y/n)");
        String answer = br.readLine();

        if(answer.isEmpty()||answer.equalsIgnoreCase("y")) {
            System.exit(0);
        }
    }
}
