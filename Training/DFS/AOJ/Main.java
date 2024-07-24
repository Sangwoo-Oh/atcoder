import java.lang.*;
import java.util.*;

public class Main {
    static int time;
    static boolean[] detected;
    static int[] foundTime;
    static int[] finishedTime;
    static void dfs(List<List<Integer>> g, int v) {
        detected[v] = true;
        foundTime[v] = time++;
        for(int u : g.get(v)) {
            if (detected[u]) continue;
            dfs(g,u);
        }
        finishedTime[v] = time++;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        List<List<Integer>> g = new ArrayList<>();
        for (int i=0; i<n; i++) g.add(new ArrayList<>());

        for (int i=0; i<n; i++) {
            int u = scanner.nextInt() - 1;
            int k = scanner.nextInt();
            for (int j=0; j<k; j++) {
                int v = scanner.nextInt() - 1;
                g.get(u).add(v);
                g.get(v).add(u);
            }
        }

        detected = new boolean[n];
        foundTime = new int[n];
        finishedTime = new int[n];
        time = 0;
        dfs(g, 0);

        for (int i=0; i<n; i++) {
            System.out.println((i+1) + " " + foundTime[i] + " " + finishedTime[i]);
        }
    }
}
