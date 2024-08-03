import java.lang.*;
import java.util.*;

public class Main {
	static ArrayList<ArrayList<Integer>> g = new ArrayList<>();
	static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /* input */
        int n = scanner.nextInt();
		int x = scanner.nextInt()-1;
		int y = scanner.nextInt()-1;


		for (int i=0; i<n; i++) g.add(new ArrayList<>());
		for (int i=0; i<n-1; i++) {
			int u = scanner.nextInt()-1;
			int v = scanner.nextInt()-1;
			g.get(u).add(v);
			g.get(v).add(u);
		}
		HashSet<Integer> set = new HashSet<>();
		ArrayList<Integer> ans = new ArrayList<>();
		visited = new boolean[n];
		dfs(x,y,set,ans);
    }
	static public void dfs(int start, int goal, HashSet<Integer> set, ArrayList<Integer> ans) {
		visited[start]=true;
		set.add(start);
		ans.add(start);

		if (start==goal) {
			for(int i: ans) System.out.print((i+1) + " ");
			System.out.println();
			System.exit(0);
		}
		for(int next: g.get(start)) {
			if(visited[next]) continue;
			if(set.contains(next)) continue;
			dfs(next, goal, set, ans);
		}
		// set.remove(start);
		ans.remove(ans.size()-1);
	}
}
