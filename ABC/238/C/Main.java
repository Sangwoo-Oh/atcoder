import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        long n = scanner.nextLong();

        long mod = 998244353;
        long x = (long)1e18;
        while (x > n) {
            x /= 10;
        }

        long ans = 0;
        while (x > 0) {
            long y = n - x + 1;
            y %= mod;
            n -= y;
            ans += y * (y + 1) / 2;
            ans %= mod;
            x /= 10;
        }
        ans %= mod;
        System.out.println(ans);
    }
}
