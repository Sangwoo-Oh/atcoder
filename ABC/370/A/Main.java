import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int l = scanner.nextInt();
        int r = scanner.nextInt();

        if (l == 1 && r == 0) {
            System.out.println("Yes");
        } else if (l == 0 && r == 1) {
            System.out.println("No");
        } else {
            System.out.println("Invalid");
        }
    }
}
