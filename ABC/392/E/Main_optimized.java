import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /* input */
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // n-sized disjoint set
        DisjointSet ds = new DisjointSet(n);
        ArrayDeque<int[]> tupleList = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            if (ds.find(a) == ds.find(b)) { // If the parents are the same, it's redundant
                tupleList.add(new int[]{i, a, b});
            } else { // If the parents are different, it's necessary
                ds.unionByRank(a, b);
            }
        }

        TreeSet<Integer> leaders = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            int leader = ds.find(i);
            leaders.add(leader);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(leaders.size() - 1).append("\n");

        while (leaders.size() > 1) {
            int[] tuple = tupleList.removeLast();
            int e = tuple[0];
            int a = tuple[1];
            int b = tuple[2];

            int u = ds.find(a);
            leaders.remove(u);

            int v = leaders.first(); // O(log n)
            leaders.remove(v);

            ds.unionByRank(u, v);
            int newLeader = ds.find(u);

            leaders.add(newLeader);

            sb.append(e + 1).append(" ").append(a + 1).append(" ").append(v + 1).append("\n");
        }

        System.out.print(sb);
    }
}

/* Optimized DisjointSet with Union by Rank & Path Compression */
class DisjointSet {
    private int[] parent, rank;

    public DisjointSet(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) parent[i] = i;
    }

    public int find(int i) {
        return (parent[i] == i) ? i : (parent[i] = find(parent[i])); // Path Compression
    }

    public void unionByRank(int i, int j) {
        int irep = find(i), jrep = find(j);
        if (irep == jrep) return;
        if (rank[irep] < rank[jrep]) {
            parent[irep] = jrep;
        } else if (rank[irep] > rank[jrep]) {
            parent[jrep] = irep;
        } else {
            parent[irep] = jrep;
            rank[jrep]++;
        }
    }
}
