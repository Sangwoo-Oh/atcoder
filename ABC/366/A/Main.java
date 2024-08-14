import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        int a = scanner.nextInt();

        int win = n/2;
        if (n==1) {
            win++;
        }

        if (t > win || a > win) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}
