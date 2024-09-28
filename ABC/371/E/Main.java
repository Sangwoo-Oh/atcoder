import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 入力の読み取り
        int N = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        // 種類数をカウントするためのマップ
        Map<Integer, Integer> countMap = new HashMap<>();
        long total = 0;  // 答えとなる総和
        int right = 0;   // 右端のポインタ

        // 各iに対して右端を伸ばしながら計算
        for (int left = 0; left < N; left++) {
            // 右端を可能な限り伸ばす
            while (right < N && (countMap.getOrDefault(A[right], 0) == 0)) {
                countMap.put(A[right], countMap.getOrDefault(A[right], 0) + 1);
                right++;
            }

            // 現在の区間 [left, right-1] での種類数を計算
            total += (right - left);

            // 左端を1つ進めるために、現在のleftの要素を減らす
            countMap.put(A[left], countMap.get(A[left]) - 1);
        }

        // 答えを出力
        System.out.println(total);
    }
}
