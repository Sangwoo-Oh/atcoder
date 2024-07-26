import java.lang.*;
import java.util.*;

public class Main {
    // static int n;
    // static int q;
    static List<List<Integer>> g;
    static long[] counter;
    // static boolean[] visit;

    public static void main(String[] args) {
        /* input */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        g = new ArrayList<>();

        // 隣接リストを初期化
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());

        // 辺情報をセット
        for (int i = 0; i < n-1; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            g.get(a).add(b);
            g.get(b).add(a);
        }

        // カウンターを0で初期化
        counter = new long[n];

        // 訪問チェック配列を初期化
        // visit = new boolean[n];

        for(int j = 0; j < q; j++) {
            int p = scanner.nextInt() - 1;
            int x = scanner.nextInt();
            counter[p] += x;
        }

        dfs(0, -1);

        for(int i = 0; i < n; i++) System.out.print(counter[i] + " ");
        System.out.println();
    }

    static void dfs(int node, int parent) {
        for (int child : g.get(node)) {
            if (child == parent) continue;
            counter[child] += counter[node];
            dfs(child, node);
        }
    }
}
