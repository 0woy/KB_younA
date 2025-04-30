package Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddCommand implements Command {
    @Override
    public void execute() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("숫자 1: ");
        int n1= Integer.parseInt(br.readLine());

        System.out.print("숫자 2: ");
        int n2= Integer.parseInt(br.readLine());

        System.out.printf("%d + %d = %d\n", n1, n2, n1 + n2);
    }
}
