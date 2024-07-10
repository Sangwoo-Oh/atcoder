import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] H = new int[N];
        for (int i = 0; i < N; i++) {
            H[i] = scanner.nextInt();
        }

        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int i = 1; i < N; i++) {
            // ope1
            for (int j = 1; j <= K; j++) {
                if (i > j-1) {
                    int ope = Math.abs(H[i-j] - H[i]);
                    if (dp[i] > dp[i-j] + ope) {
                        dp[i] = dp[i-j] + ope;
                    }
                }
            }
        }
        System.out.println(dp[N-1]);
    }
}
