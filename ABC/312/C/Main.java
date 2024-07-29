import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long[] a = new long[n];
        long[] b = new long[m];
        for (int i = 0; i < n; i++) a[i]=scanner.nextLong();
        for (int i = 0; i < m; i++) b[i]=scanner.nextLong();

        Arrays.sort(a);
        Arrays.sort(b);

        long ok = Math.max(a[n-1], b[m-1]+1); // 売る人n人 買う人0人
        long ng = Math.min(a[0]-1, b[0]); // 売る人0人 買う人m人

        while (Math.abs(ok - ng) > 1) {
            long x = (ok + ng)/2;
            // System.out.println(ng + " " + x + " " + ok);
            if (judge(x, a, b)) {
                ok = x;
            } else {
                ng = x;
            }
        }

        System.out.println(ok);
    }

    static public boolean judge(long x, long[] a, long[] b) {
        int a_num = lower_bound(x+1, a); // x円以上で売る人数
        // System.out.println(lower_bound(x+1, a));
        // System.out.println(x + "円以上で売る人数:" + a_num);
        int b_num = b.length - lower_bound(x, b); // x円以下で買う人数
        // System.out.println(lower_bound(x, b));
        // System.out.println(x + "円以下で買う人数:" + b_num);
        return a_num >= b_num;
    }

    static public int lower_bound(long x, long[] arr) {
        int left = -1;
        int right = arr.length;

        while (right-left>1) {
            int m = (left + right) / 2;
            if (arr[m] >= x) {
                right = m;
            } else {
                left = m;
            }
        }

        return right;
    }
}
