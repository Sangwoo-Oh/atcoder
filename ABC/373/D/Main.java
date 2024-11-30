import java.util.*;

public class Main {

    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  // 頂点数
        int M = sc.nextInt();  // 辺の数

        // グラフの作成
        List<Edge>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 辺の入力
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, -w));
        }

        // 頂点に書き込む値（まだ決まっていない場合は null）
        Long[] x = new Long[N + 1];

        // BFSで探索するメソッド
        if (!bfsAllComponents(graph, x, N)) {
            System.out.println("No solution");
            return;
        }

        // 結果を出力
        for (int i = 1; i <= N; i++) {
            System.out.print(x[i] + " ");
        }
    }

    // すべての連結成分に対して BFS を行う
    static boolean bfsAllComponents(List<Edge>[] graph, Long[] x, int N) {
        for (int i = 1; i <= N; i++) {
            if (x[i] == null) {  // まだ訪れていない頂点の場合
                if (!bfs(i, graph, x)) {
                    return false;
                }
            }
        }
        return true;
    }

    // BFSを使用して、連結成分内のすべての頂点の値を決定
    static boolean bfs(int start, List<Edge>[] graph, Long[] x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        x[start] = 0L;  // 開始点の値は 0 とする

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (Edge edge : graph[u]) {
                int v = edge.to;
                long w = edge.weight;

                if (x[v] == null) {  // まだ v の値が決まっていない場合
                    x[v] = x[u] + w;
                    queue.add(v);
                } else if (x[v] != x[u] + w) {  // 矛盾が発生した場合
                    return false;
                }
            }
        }
        return true;
    }
}
