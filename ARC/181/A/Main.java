import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // テストケースの数を読み込む
        int T = scanner.nextInt();
        int[] results = new int[T];

        for (int t = 0; t < T; t++) {
            // 各ケースのNを読み込む
            int N = scanner.nextInt();
            int[] P = new int[N];
            for (int i = 0; i < N; i++) {
                P[i] = scanner.nextInt();
            }

            // 操作回数を数える変数
            int operations = 0;

            // 配列がソートされているかどうかをチェック
            if (isSorted(P)) {
                operations = 0;
            } else if (P[0] == 1 || P[N-1] == N) {
                operations = 1;
            } else if (P[0] == N && P[N-1] == 1) {
                operations = 3;
            } else {
                operations = 2;
            }

            // 結果を保存
            results[t] = operations;
        }

        // 結果を出力
        for (int result : results) {
            System.out.println(result);
        }
    }

    // 配列がソートされているかをチェックするヘルパーメソッド
    public static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i-1] > array[i]) {
                return false;
            }
        }
        return true;
    }
}
