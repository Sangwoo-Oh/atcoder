import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int N = scanner.nextInt();
        int W = scanner.nextInt();

        int[] w = new int[N];
        int[] v = new int[N];

        for (int i=0; i<N; i++) {
            w[i] = scanner.nextInt();
            v[i] = scanner.nextInt();
        }

        long[][] dp = new long[N+1][W+1];

        // wが馬鹿でかいことによって、そのまま配列で表現しようとすると、アウトオブメモリーとなる
        // 言い換えが必要

        for (int i=0; i<N; i++) {
            for (int j=0; j<W; j++) {
                // i番目を選ばない場合
                dp[i+1][j+1] = dp[i][j+1];
                // i番目を選ぶ場合
                if (j + 1 >= w[i]) {
                    // System.out.println(dp[i+1][j+1] +" , "+ dp[i][j + 1-w[i]] + v[i]);
                    dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j + 1-w[i]]+v[i]);
                }
            }
            // System.out.println(Arrays.toString(dp[i+1]));
        }

        System.out.println(dp[N][W]);

    }
}
