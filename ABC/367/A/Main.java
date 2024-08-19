import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if (b <= c) {
            if (b <= a && a <= c) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        } else {
            if (a >= b || a <= c) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
    }
}
