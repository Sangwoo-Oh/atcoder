import java.lang.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int target;
    Long cost;

    Edge(int target, long cost) {
        this.target = target;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return Long.compare(this.cost, o.cost);
    }
}

public class Main {
    static long INF = Long.MIN_VALUE;
    static int n, m;
    static List<List<Edge>> edges;
    static boolean[] visited;
    static long max;
    public static void main(String[] args) {
        /* input */
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        edges = new ArrayList<>();
        for (int i = 0; i < n; i++) edges.add(new ArrayList<>());
        for (int i=0; i<m; i++) {
            int a = scanner.nextInt(); a--;
            int b = scanner.nextInt(); b--;
            int c = scanner.nextInt();
            edges.get(a).add(new Edge(b, c));
            edges.get(b).add(new Edge(a, c));
        }

        visited = new boolean[n];
        max = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dfs(i, 0);
        }
        System.out.println(max);
    }

    static void dfs(int v, long distance) {
        visited[v] = true;
        max = Math.max(max, distance);
        for (Edge u : edges.get(v)) {
            if (visited[u.target]) continue;
            dfs(u.target, distance + u.cost);
        }
        visited[v] = false;
    }
}
