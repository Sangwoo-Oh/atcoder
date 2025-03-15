import java.lang.*;
import java.util.*;

class Edge {
    int target;
    long cost;

    Edge(int target, long cost) {
        this.target = target;
        this.cost = cost;
    }
}


public class Main {
    static List<List<Edge>> edges = new ArrayList<>();
    static boolean[] visited;
    static long min;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<Edge>());
        }

        for (int i=0; i<m; i++) {
            int u = scanner.nextInt(); u--;
            int v = scanner.nextInt(); v--;
            long w = scanner.nextLong();
            edges.get(u).add(new Edge(v, w));
            edges.get(v).add(new Edge(u, w));
        }

        visited = new boolean[n];
        min = Long.MAX_VALUE;

        visited[0] = true;
        dfs(0, n-1, visited, 0);

        System.out.println(min);
    }

    static public void dfs(int v, int n, boolean[] visited, long xor) {
        if (v == n) {
            min = Math.min(min, xor);
            return;
        } 

        for (Edge u : edges.get(v)) {
            if (!visited[u.target]) {
                visited[u.target] = true;
                dfs(u.target, n, visited, xor ^ u.cost);
                visited[u.target] = false;
            }
        }

    }
}
