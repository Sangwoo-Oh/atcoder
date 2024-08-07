import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int n = scanner.nextInt();
        int w = scanner.nextInt();

        long[][] wv = new long[n][2];
        for (int i=0; i<n; i++) {
            wv[i][0] = scanner.nextLong();
            wv[i][1] = scanner.nextLong();
        }

        int MAX_V = 100001;
        long[][] dp = new long[n+1][MAX_V];

        for (int i=0; i<=n; i++) for (int j=0; j<MAX_V; j++) dp[i][j] = Long.MAX_VALUE;
        dp[0][0] = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<MAX_V; j++) {
                if (j-wv[i][1] >= 0) {
                    if (dp[i][j-(int)wv[i][1]] != Long.MAX_VALUE) {
                        dp[i+1][j] = Math.min(dp[i][j], dp[i][j-(int)wv[i][1]] + wv[i][0]);
                    } else {
                        dp[i+1][j] = dp[i][j];
                    }
                } else dp[i+1][j] = dp[i][j];
            }
        }

        int ans=100000;
        while(dp[n][ans]>w)ans--;
        System.out.println(ans);
    }
}
