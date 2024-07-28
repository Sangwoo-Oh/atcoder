import java.lang.*;
import java.util.*;

public class Main {
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
        }
        for (int i=0; i<n; i++) {
            b[i] = scanner.nextLong();
        }

        Arrays.sort(a, Collections.reverseOrder());
        Arrays.sort(b, Collections.reverseOrder());

        long a_sum = 0;
        int a_cnt = 0;
        for (Long num : a) {
            a_sum += num;
            a_cnt += 1;
            if (a_sum > x) break;
        }

        long b_sum = 0;
        int b_cnt = 0;
        for (Long num : b) {
            b_sum += num;
            b_cnt += 1;
            if (b_sum > y) break;
        }

        int ans = Math.min(a_cnt, b_cnt);

        System.out.println(ans);

    }
}
