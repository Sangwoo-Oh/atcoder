import java.lang.*;
import java.util.*;

public class Main {
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        int k = scanner.nextInt();

        char[][] c = new char[h][w];
        for (int i = 0; i < h; i++) {
            c[i] = scanner.next().toCharArray();
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (c[i][j] == '#') continue;
                boolean[][] seen = new boolean[h][w];
                dfs(c, i, j, k, seen);
            }
        }
        System.out.println(cnt);
    }
    static void dfs(char[][] c, int i, int j, int k, boolean[][] seen) {
        
        if (i < 0 || i >= c.length || j < 0 || j >= c[0].length) return;
        if (seen[i][j]) return;
        if (c[i][j] == '#') return;
        if (k == 0) {
            cnt++;
            return;
        }
        seen[i][j] = true;
        dfs(c, i-1, j, k-1, seen);
        dfs(c, i+1, j, k-1, seen);
        dfs(c, i, j-1, k-1, seen);
        dfs(c, i, j+1, k-1, seen);
        seen[i][j] = false;
    }
}
