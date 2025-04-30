package Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        Command[] commands = new Command[] {
                new AddCommand(),
                new OpenCommand(),
                new PrintCommand(),
                new ExitCommand()
        };

        while (true){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("1: Add , 2:Open, 3:Print, 4:Exit");
            System.out.print("선택: ");
            int c = Integer.parseInt(br.readLine());

            commands[c-1].execute();
        }
    }
}
