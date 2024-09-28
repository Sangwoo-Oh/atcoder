import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
        }

        boolean[][] dp = new boolean[n + 1][x + 1];
        dp[0][0] = true;

        for (int i=1; i<=n; i++) {
            for (int j=0; j<=x; j++) {
                int A = a[i-1];
                int B = b[i-1];
                if (j >= A && dp[i-1][j-A]) {
                    dp[i][j] = dp[i-1][j-A];
                }
                if (j >= B && dp[i-1][j-B]) {
                    dp[i][j] = dp[i-1][j-B];
                }
            }
        }
        System.out.println(dp[n][x] ? "Yes" : "No");
    }
}
