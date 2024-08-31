import java.lang.*;
import java.util.*;

public class Main {
    // static int[][] dp = new int[10][1000001];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int mod = 998244353;
        int[][] dp = new int[10][n+1];
        for (int d=1; d<=9; d++) {
            dp[d][1] = 1;
        }

        for (int i=2; i<=n; i++) {
            for (int d=1; d<=9; d++) {
                if(d >= 2) {
                    dp[d][i] += dp[d-1][i-1];
                    dp[d][i] %= mod;
                }
                dp[d][i] += dp[d][i-1];
                dp[d][i] %= mod;
                if(d <= 8) {
                    dp[d][i] += dp[d+1][i-1];
                    dp[d][i] %= mod;
                }
            }
        }

        int ans = 0;
        for (int i=1; i<=9; i++) {
            ans += dp[i][n];
            ans %= mod;
        }
        System.out.println(ans);
    }
}
