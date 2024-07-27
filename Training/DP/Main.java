import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n]; for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i+1][j] = dp[i][j];
                if (a[i] <= j) dp[i+1][j] |= dp[i][j-a[i]];
            }
        }
        if (dp[n][m]) System.out.println("Yes");
        else System.out.println("No");
    }
}
