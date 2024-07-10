import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int N = scanner.nextInt();
        int[][] activities = new int[N][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                activities[i][j] = scanner.nextInt();
            }
        }

        int[][] dp = new int[N][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                if (j == k) continue;
                if (dp[0][k] < activities[0][k]) {
                    dp[0][k] = activities[0][k];
                }
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (j == k) continue;
                    if (dp[i][k] < dp[i-1][j] + activities[i][k]) {
                        dp[i][k] = dp[i-1][j] + activities[i][k];
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < 3; i++) {
            if (max < dp[N-1][i]) {
                max = dp[N-1][i];
            }
        }
        System.out.println(max);
    }
}
