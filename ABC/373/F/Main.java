import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();  // 品物の種類数
        int W = sc.nextInt();  // ナップサックの容量
        int[] w = new int[N];  // 各品物の重さ
        int[] v = new int[N];  // 各品物の価値
        
        // 各品物の重さと価値を入力
        for (int i = 0; i < N; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        // DP配列を作成 (容量 W + 1 まで)
        long[] dp = new long[W + 1];
        Arrays.fill(dp, Long.MIN_VALUE);  // 初期化 (最小値)
        dp[0] = 0;  // 重さが 0 のときのうれしさは 0
        
        // 各品物ごとにDPを更新
        for (int i = 0; i < N; i++) {
            // 1種類の品物について計算
            for (int j = W; j >= 0; j--) {  // 現在の重さ j から逆順にDPを更新する
                for (int k = 1; k <= 3000 && k * w[i] <= j; k++) {
                    // k 個選んだ時のうれしさを計算
                    long happiness = k * (long) v[i] - k * (long) k;
                    dp[j] = Math.max(dp[j], dp[j - k * w[i]] + happiness);
                }
            }
        }

        // 答えを出力 (dp[W] が最大のうれしさ)
        long answer = 0;
        for (int j = 0; j <= W; j++) {
            answer = Math.max(answer, dp[j]);
        }
        System.out.println(answer);
    }
}
