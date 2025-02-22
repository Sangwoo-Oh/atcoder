import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
		int m = scanner.nextInt();

		// n-sized disjoint set
		DisjointSet ds = new DisjointSet(n);
		ArrayDeque<int[]> tupleList = new ArrayDeque<>();
		for (int i=0; i<m; i++) {
			int a = scanner.nextInt()-1;
			int b = scanner.nextInt()-1;

			if (ds.find(a) == ds.find(b)) { // If the parents are same, it means this edge is redundant
				tupleList.add(new int[]{i, a, b});
			} else { // It the parents are different, it means this edge is neccesary
				ds.unionByRank(a, b);
			}
		}

		TreeSet<Integer> leaders = new TreeSet<>();
		for (int i=0; i<n; i++) {
			leaders.add(ds.find(i));
		}

		System.out.println(leaders.size()-1);
		while (leaders.size() > 1) {
			int[] tuple = tupleList.removeLast();
			int e = tuple[0];
			int a = tuple[1];
			int b = tuple[2];

			int u = ds.find(a); leaders.remove(u);
			int v = leaders.first(); leaders.remove(v);

            ds.unionByRank(u, v);
            int newLeader = ds.find(u); leaders.add(newLeader);

			// System.out.printf("%d %d %d\n", e+1, a+1, v+1); // printfは遅い。
            // 数万行出力が必要な場合は、StringBuilderを使って最後にまとめてアウトプットしたほうがよい。
            System.out.println((e+1) + " " + (a+1) + " " + (v+1));
			
		}
    }
}


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