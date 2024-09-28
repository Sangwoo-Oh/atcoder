import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        long n = scanner.nextLong();
        long ans = 0;

        for (long a = 1; a * a * a <= n; a++) {
            for (long b = a; b * b <= n; b++) {
                ans += n/a/b - b + 1;
            }
        }
        System.out.println(ans);
    }
}
