import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        DisjointSet uf = new DisjointSet(n);
        int ans = 0;
        for (int i=0;i<m;i++) {
            int a = scanner.nextInt()-1;
            int b = scanner.nextInt()-1;
            if (uf.find(a) == uf.find(b)) ans++;
            else uf.unionByRank(a,b);
        }
        System.out.println(ans);
    }
}


class DisjointSet {

	private int[] parent;
	private int[] rank;

	// Constructor to initialize the DisjointSet data
	// structure
	public DisjointSet(int size)
	{
		parent = new int[size];
		rank = new int[size];

		// Initialize each element as a separate set with
		// rank 0
		for (int i = 0; i < size; i++) {
			parent[i] = i;
			rank[i] = 0;
		}
	}

	// Function to find the representative (or the root
	// node) of a set with path compression
	public int find(int i)
	{
		if (parent[i] != i) {
			parent[i] = find(parent[i]); // Path compression
		}
		return parent[i];
	}

	// Unites the set that includes i and the set that
	// includes j by rank
	public void unionByRank(int i, int j)
	{
		// Find the representatives (or the root nodes) for
		// the set that includes i and j
		int irep = find(i);
		int jrep = find(j);

		// Elements are in the same set, no need to unite
		// anything
		if (irep == jrep) {
			return;
		}

		// Get the rank of i's tree
		int irank = rank[irep];

		// Get the rank of j's tree
		int jrank = rank[jrep];

		// If i's rank is less than j's rank
		if (irank < jrank) {
			// Move i under j
			parent[irep] = jrep;
		}
		// Else if j's rank is less than i's rank
		else if (jrank < irank) {
			// Move j under i
			parent[jrep] = irep;
		}
		// Else if their ranks are the same
		else {
			// Move i under j (doesn't matter which one goes
			// where)
			parent[irep] = jrep;
			// Increment the result tree's rank by 1
			rank[jrep]++;
		}
	}

	// Example usage
	public static void main(String[] args)
	{
		int size = 5;
		DisjointSet ds = new DisjointSet(size);

		// Perform some union operations
		ds.unionByRank(0, 1);
		ds.unionByRank(2, 3);
		ds.unionByRank(1, 3);

		// Find the representative of each element and print
		// the result
		for (int i = 0; i < size; i++) {
			System.out.println(
				"Element " + i
				+ " belongs to the set with representative "
				+ ds.find(i));
		}
	}
}
