import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  // 候補者の人数
        int M = sc.nextInt();  // 当選するために上位になるべき人数
        long K = sc.nextLong(); // 総投票数
        long[] A = new long[N]; // 各候補者の現在の得票数

        // A の入力
        long currentSum = 0;
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextLong();
            currentSum += A[i];  // 現在の合計票数
        }

        // 残りの票数
        long remainingVotes = K - currentSum;

        // 候補者のインデックスを保持するペア
        Candidate[] candidates = new Candidate[N];
        for (int i = 0; i < N; i++) {
            candidates[i] = new Candidate(A[i], i);
        }

        // 得票数に基づいてソート
        Arrays.sort(candidates, (a, b) -> Long.compare(b.votes, a.votes));

        // 結果を保持する配列
        long[] result = new long[N];
        Arrays.fill(result, -1); // 初期化（当選不可を意味する -1）

        // 上位 M-1 人の得票数を確認し、各候補者がどれだけ必要か計算
        for (int i = 0; i < N; i++) {
            Candidate c = candidates[i];
            long myVotes = c.votes;

            // 当選確定している場合
            if (i < M) {
                result[c.index] = 0;
                continue;
            }

            // 上位M-1位との差を確認
            long neededVotes = candidates[M - 1].votes + 1 - myVotes;

            if (neededVotes <= 0) {
                // すでに上位に入っている場合
                result[c.index] = 0;
            } else if (neededVotes <= remainingVotes) {
                // 必要な票数が残りの票数以下ならその票数が必要
                result[c.index] = neededVotes;
            } else {
                // 残り票数が足りず、どんなに頑張っても当選不可能
                result[c.index] = -1;
            }
        }

        // 結果を出力
        for (int i = 0; i < N; i++) {
            System.out.print(result[i]);
            if (i < N - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    // 候補者のクラス（得票数とインデックスを保持）
    static class Candidate {
        long votes;
        int index;

        Candidate(long votes, int index) {
            this.votes = votes;
            this.index = index;
        }
    }
}
