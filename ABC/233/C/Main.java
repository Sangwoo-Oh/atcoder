import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        long x = scanner.nextLong();
        long[][] a = new long[n][];
        for (int i = 0; i < n; i++) {
            int l = scanner.nextInt();
            a[i] = new long[l];
            for (int j=0; j<l; j++) {
                a[i][j] = scanner.nextLong();
            }
        }

        long ans = 0;
        ans = dfs(n, x, a, 0, 1);

        System.out.println(ans);
    }

    /**
     * param 1: number of bags
     * param 2: target value
     * param 3: bag and balls
     * param 4: index of bags
     * param 5: index of balls
     */
    static long dfs(int n, long x, long[][] a, int i, long k) {
        if (i == n) {
            if (x == k) {
                return 1;
            } else {
                return 0;
            }
        } 
        long ans = 0;
        for (long y : a[i]) {
            long z = k * y;
            if (z <= x) {
                ans += dfs(n, x, a, i+1, z);
            }
        }
        return ans;
    }
}
