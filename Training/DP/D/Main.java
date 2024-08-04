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

        long[][] dp = new long[w+1][n+1];

        for(int j=0; j<=w; j++) dp[j][0] = 0;

        for (int i=0; i<n; i++) {
            for (int j=1; j<=w; j++) {
                if (wv[i][0] > j) {
                    dp[j][i+1]=dp[j][i];
                } else {
                    dp[j][i+1]=Math.max(dp[j][i], dp[j-(int)wv[i][0]][i] + wv[i][1]);
                }
            }
        }

        long ans = dp[w][n];
        System.out.println(ans);
    }
}
