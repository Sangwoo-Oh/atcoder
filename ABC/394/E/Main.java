import java.util.*;

class Pair {
    int node;
    String str;

    public Pair(int node, String str) {
        this.node = node;
        this.str = str;
    }
}

public class Main {
    static int n;
    static char[][] c;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        n = scanner.nextInt();
        c = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = scanner.next();
            c[i] = line.toCharArray();
        }

        int[][] ans = new int[n][n];
        int INF = 100100100;
        
        for (int i = 0; i < n; i++) {
            LinkedList<Pair> queue = new LinkedList<>();
            int[] dist = new int[n];
            Arrays.fill(dist, INF);
            dist[i] = 0;
            queue.add(new Pair(i, ""));

            while (!queue.isEmpty()) {
                Pair v = queue.poll();
                
                if (isPali(v.str) && !v.str.isEmpty()) {
                    dist[v.node] = v.str.length();
                }
                
                for (int j = 0; j < n; j++) {
                    if (c[v.node][j] == '-')
                        continue;
                    
                    if (dist[j] != INF)
                        continue;
                    
                    queue.add(new Pair(j, v.str + c[v.node][j]));
                }
            }

            for (int j = 0; j < n; j++) {
                ans[i][j] = (dist[j] == INF) ? -1 : dist[j];
            }
        }

        for (int[] row : ans) {
            System.out.println(Arrays.toString(row).replaceAll("[\[\],]", ""));
        }
    }

    public static boolean isPali(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
