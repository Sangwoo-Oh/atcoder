import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 入力
        int n = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }

        long[][] dp = new long[n + 1][2];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = Long.MIN_VALUE;
            dp[i][1] = Long.MIN_VALUE;
        }
        dp[0][0] = 0; // 0匹目まで倒すかどうか決めて偶数匹倒したときの最大値

        // DPの遷移
        for (int i = 0; i < n; i++) {
            int ni = i+1;
            for (int j = 0; j < 2; j++) {
                { // o
                    int nj = j^1;
                    long x = j%2==1 ? a[i] * 2 : a[i];
                    dp[ni][nj] = Math.max(dp[ni][nj], dp[i][j] + x); 
                }
                { // x
                    int nj = j;
                    dp[ni][nj] = Math.max(dp[ni][nj], dp[i][j]);
                }
            }
        }

        // 最後のモンスターまで見たときの最大経験値を出力
        System.out.println(Math.max(dp[n][0], dp[n][1]));
    }
}
