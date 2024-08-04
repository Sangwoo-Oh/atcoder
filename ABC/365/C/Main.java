import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        long m = scanner.nextLong();
        long[] a = new long[n];
        long sum = 0;
        for (int i = 0; i<n; i++ ) {
            a[i] = scanner.nextLong();
            sum += a[i];
        }
        if (sum <= m) {
            System.out.println("infinite");
            return;
        }

        long ng = -1;
        long ok = sum+1;

        while (ok - ng > 1) {
            long mid = (ok + ng) / 2;
            long cnt = 0;
            for (int i = 0; i<n; i++ ) {
                cnt += Math.min(mid, a[i]);
            }
            if (cnt <= m) {
                ng = mid;
            } else {
                ok = mid;
            }
        }
        System.out.println(ng);
    }
}
