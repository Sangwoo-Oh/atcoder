import java.util.*;
import java.lang.*;

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
    static int n, m;
    static long[] a;
    static final long INF = Long.MAX_VALUE; /**set max value */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        n = scanner.nextInt();
        m = scanner.nextInt();

        /* 頂点の重み */
        a = new long[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextLong();

        /* 隣接辺行列 adjacent edges */
        List<List<Edge>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<Edge>());
        }


        for (int i = 0; i < m; i++) {
            int u,v;
            long b;
            u = scanner.nextInt(); u--;
            v = scanner.nextInt(); v--;
            b = scanner.nextLong();
            edges.get(u).add(new Edge(v, b+a[v]));
            edges.get(v).add(new Edge(u, b+a[u])); /** because of undirected graph */
        }



        /* algorithm */

        long[] distance = new long[n]; Arrays.fill(distance, INF); /** set all to INF */

        distance[0] = a[0]; /** settle start point */
        Queue<Edge> q = new PriorityQueue<Edge>();
        q.add(new Edge(0, a[0])); /** settle start point */

        while (!q.isEmpty()) {
            Edge e = q.poll();
            if (distance[e.target] < e.cost) {
                continue;
            }

            for (Edge v : edges.get(e.target)) {
                long nd = distance[e.target] + v.cost;
                if (distance[v.target] > nd) {
                    distance[v.target] = nd;
                    q.add(new Edge(v.target, nd));
                }
            }
        }

        /* output */
        for (int i = 1; i < n; i++) System.out.print(distance[i] + " ");
        System.out.println();
    }

    /* next permutation method */
    static boolean next_permutation(int[] array, int start, int end) {
        if(array == null || start > end || start < 0 || end > array.length) {
            System.out.println("Error: 引数が正しくありません。");
            return false;
        }

        for(int i=end-2; i>=start; i--) {
            if(array[i] < array[i+1]) {
                int j = end - 1;
                while(array[i] >= array[j]) {
                    j--;
                }

			    //swap
                int tmp = array[j];
                array[j] = array[i];
                array[i] = tmp;

                Arrays.sort(array, i+1, end);

                return true;
            }
        }
        return false;
    }
}
