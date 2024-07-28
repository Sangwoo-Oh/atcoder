import java.lang.*;
import java.util.*;

public class Main {
    static int ans;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        long x = scanner.nextLong();
        long y = scanner.nextLong();

        Long[] a = new Long[n];
        Long[] b = new Long[n];
        for (int i=0; i<n; i++) {
            a[i] = scanner.nextLong();
            b[i] = scanner.nextLong();
        }
        ans = Integer.MIN_VALUE;
        rec(0, 0, 0, 0 , a, b, x, y);
        System.out.println(ans);

    }
    static void rec(int index, int total, long total_a, long total_b, Long[] a, Long[] b, long x, long y) {
        if (total_a > x) return;
        if (total_b > y) return;
        if (index >= a.length) return;

        ans = Math.max(ans, total);
        rec(index+1, total+1, total_a, total_b , a, b, x, y);
        rec(index, total, total_a+a[index], total_b +b[index], a, b, x, y);
    }
}
