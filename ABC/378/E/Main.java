import java.lang.*;
import java.util.*;

public class Main {
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        long[] b = new long[n+1];
        b[0] = 0;
        for (int i=1; i<=n; i++) {
            b[i] = b[i-1] + a[i-1];
        }
        long[] c = new long[n+1];
        c[0] = 0;
        for (int i=3; i<=n; i++) {
            c[i] = c[i] + b[i-1] % m + a[i-1] % m;
            System.out.println(c[i]);
        }
        
    }
}
