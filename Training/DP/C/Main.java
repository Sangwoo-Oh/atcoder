import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int n = scanner.nextInt();
        int[][] abc = new int[n][3];
        for (int i=0; i<n; i++) {
            abc[i][0] = scanner.nextInt();
            abc[i][1] = scanner.nextInt();
            abc[i][2] = scanner.nextInt();
        }

        int[][] dp = new int[n+1][3];
        Arrays.fill(dp[0], 0);

        for (int i=0; i<n; i++) {
            for (int j=0; j<3; j++) { // j: i+1日目に選ぶ活動
                for (int k=0; k<3; k++) { // k: i日目に選んだ活動
                    if (j == k) continue;
                    dp[i+1][j] = Math.max(dp[i+1][j], dp[i][k] + abc[i][j]);
                }
            }
        }

        int ans = Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2]));
        System.out.println(ans);
    }
}
