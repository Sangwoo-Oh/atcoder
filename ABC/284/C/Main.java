import java.lang.*;
import java.util.*;


public class Main {
	static List<List<Integer>> g = new ArrayList<>();
	static boolean[] visited;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
		int m = scanner.nextInt();
		for (int i=0; i<n; i++) g.add(new ArrayList<>());
		for (int i=0; i<m; i++) {
			int u = scanner.nextInt()-1;
			int v = scanner.nextInt()-1;
			g.get(u).add(v);
			g.get(v).add(u);
		}
		visited = new boolean[n];

		int cnt = 0;
		Queue<Integer> q = new LinkedList<>();
		for (int i=0; i<n; i++) {
			if (visited[i]) continue;
			q.add(i); visited[i]=true;
			while (!q.isEmpty()) {
				int u = q.poll();
				for (int v : g.get(u)) {
					if(visited[v]) continue;
					visited[v] = true;
					q.add(v);
				}
			}
			cnt++;
		}

		System.out.println(cnt);
    }
}
