import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 入力を読み込む
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        // 配列をソート
        Arrays.sort(A);

        // 累積和を計算
        long[] prefixSum = new long[N + 1];
        for (int i = 0; i < N; i++) {
            prefixSum[i + 1] = prefixSum[i] + A[i];
        }

        // Kを超える最初のインデックスを探す
        int index = -1;
        for (int i = 0; i <= N; i++) {
            if (prefixSum[i] >= K) {
                index = i;
                break;
            }
        }

        // 累積和がKを超える部分が存在しない場合
        if (index == -1) {
            System.out.println("No");
            return;
        }

        // 条件を満たす並べ替えが可能かどうかを確認
        boolean isGood = true;
        for (int i = 1; i < index; i++) {
            if (prefixSum[i] >= K) {
                isGood = false;
                break;
            }
        }

        // 条件を満たす場合は並べ替え後の配列を出力
        if (isGood) {
            System.out.println("Yes");
            for (int i = 0; i < N; i++) {
                System.out.print(A[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("No");
        }
    }
}
