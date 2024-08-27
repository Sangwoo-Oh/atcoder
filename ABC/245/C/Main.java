import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        boolean[][] dp = new boolean[2][n];
        dp[0][0] = true;
        dp[1][0] = true;

        for (int i=1; i<n; i++) {
            dp[0][i] = (dp[0][i-1] && Math.abs(a[i-1] - a[i]) <= k) || dp[1][i-1] && Math.abs(b[i-1] - a[i]) <= k;
            dp[1][i] = (dp[0][i-1] && Math.abs(a[i-1] - b[i]) <= k) || dp[1][i-1] && Math.abs(b[i-1] - b[i]) <= k;
        }
        if (dp[0][n-1] || dp[1][n-1]) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
