import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();

        Arrays.sort(a);
        int dist = a[n-1] - a[0];

        for (int j = 0; j < q; j++) {
            int b = scanner.nextInt();
            int k = scanner.nextInt();

            int l = -1; // 取りうる範囲の最小値
            int r = (int)2e8; // 取りうる範囲の最大値
            while (l <= r) {
                int m = (l+r)/2;
                if (f(a,b,n,m,k)) { // k個より少なかったら
                    r = m-1;
                } else {
                    l = m+1;
                }
            }

            System.out.println(l);
        }
    }

    public static boolean f(int[] a, int b, int n, int x, int k) {
        int l = 0;
        int r = n-1;
        while(l <= r) {
            int m = (l + r)/2;
            if (a[m] >= b + x + 1) {
                r = m-1;
            } else {
                l = m+1;
            }
        }
        int upper_i = r;

        l = 0;
        r = n-1;
        while(l<=r) {
            int m = (l + r)/2;
            if (a[m] >= b-x) {
                r = m-1;
            } else {
                l = m+1;
            }
        }
        int lower_i = r;
        return upper_i - lower_i >= k;
    }
}
