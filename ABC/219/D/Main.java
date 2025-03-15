import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i=0; i<n; i++) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
        }

        // i番目まで見て、たこ焼きj個、たい焼きk個を手に入れるために必要な弁当の個数
        // i番目まで見て、たこ焼きj個、たい焼きk個を手に入れること不可能な場合の値は-1

        int[][][] dp = new int[n+1][x+1][y+1];
        // initialization
        for (int i=0; i<=n; i++) for (int j=0; j<=x; j++) for (int k=0; k<=y; k++) {
            dp[i][j][k] = 1000000;
        }
        dp[0][0][0] = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<=x; j++) {
                for (int k=0; k<=y; k++) {
                    dp[i+1][j][k] = Math.min(dp[i+1][j][k], dp[i][j][k]);
                    dp[i+1][Math.min(j+a[i], x)][Math.min(k+b[i], y)] = Math.min(dp[i+1][Math.min(j+a[i], x)][Math.min(k+b[i], y)], dp[i][j][k]+1);
                }
            }
        }

        if (dp[n][x][y] == 1000000) {
            System.out.println(-1);
        } else {
            System.out.println(dp[n][x][y]);
        }

    }
}
