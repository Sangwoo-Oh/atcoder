import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            char b = scanner.next().charAt(0);

            if (b=='M') {
                if (set.contains(a)) {
                    System.out.println("No");
                } else {
                    System.out.println("Yes");
                    set.add(a);
                }
            } else {
                System.out.println("No");
            }
        }
    }
}
