import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int N = scanner.nextInt();
        int[] H = new int[N];
        for (int i = 0; i < N; i++) {
            H[i] = scanner.nextInt();
        }

        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int i = 1; i < N; i++) {
            // ope1
            int ope1 = Math.abs(H[i-1] - H[i]);
            if (dp[i] > dp[i-1] + ope1) {
                dp[i] = dp[i-1] + ope1;
            }
            // ope2
            if (i > 1) {
                int ope2 = Math.abs(H[i-2] - H[i]);
                if (dp[i] > dp[i-2] + ope2) {
                    dp[i] = dp[i-2] + ope2;
                }
            }
        }
        System.out.println(dp[N-1]);
    }
}
