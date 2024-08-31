import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        long[] a = new long[n];
        for (int i=0; i<n; i++) {
            a[i] = scanner.nextLong();
        }
        long ans = 0;
        ans += n;

        if (n == 1) {
            System.out.println(1);
            return;
        }

        ans += n-1;

        long diff = a[1] - a[0];
        long c = 1;
        for (int i=1; i<n-1; i++) {
            if (a[i+1] - a[i] == diff) {
                c += 1;
            } else {
                diff = a[i+1] - a[i];
                ans += c * (c-1) / 2;
                c = 1;
            }
        }
        ans += c * (c-1) / 2;
        System.out.println(ans);
    }
}
