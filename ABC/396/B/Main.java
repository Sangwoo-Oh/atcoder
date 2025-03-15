import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int q = scanner.nextInt();

        LinkedList<Integer> stack = new LinkedList<Integer>();

        for (int i=0; i<100; i++) {
            stack.push(0);
        }

        for (int i=0; i<q; i++) {
            int p = scanner.nextInt();
            if (p==1) {
                int x = scanner.nextInt();
                stack.push(x);
            } else {
                int r = stack.pop();
                System.out.println(r);
            }
        }
    }
}
