import java.lang.*;
import java.util.*;

class Edge implements Comparable {
    int target;
    long cost;

    Edge(int target, long cost) {
        this.target = target;
        this.cost = cost;
    }

    @Override
    public int compareTo(Object other) {
        Edge o = (Edge)other;
        return (int)(this.cost - o.cost);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int[] t = new int[n];
        HashMap<Integer, ArrayList<Integer>> edges = new HashMap<>();
        for (int i=0; i<n; i++) {
            t[i] = scanner.nextInt();
            int k = scanner.nextInt();
            edges.put(i, new ArrayList<>());
            for (int j=0; j<k; j++) {
                edges.get(i).add(scanner.nextInt()-1);
            }
        }

        boolean[] need = new boolean[n];
        boolean[] visited = new boolean[n];
        dfs(n-1, edges, need, visited);
        long ans = 0;
        for (int i=0; i<n; i++) {
            if (need[i]) {
                ans += t[i];
            }
        }
        System.out.println(ans);
    }

    public static void dfs (int v, HashMap<Integer, ArrayList<Integer>> edges, boolean[] need, boolean[] visited) {
        need[v] = true;
        visited[v] = true;
        for (int u: edges.get(v)) {
            if (visited[u]) {
                continue;
            }
            dfs(u, edges, need, visited);
        }
    }
}
