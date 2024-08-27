import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        String[] s = new String[n];
        for (int i=0; i<n; i++) {
            s[i] = scanner.next();
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (s[i].charAt(j) == '.') continue;
                // 0 1 2
                // 3 x 4
                // 5 6 7
                for (int d = 0; d<8; d++) {
                    if (dfs(i,j,2,5,s,d)) {
                        System.out.println("Yes");
                        return;
                    }
                }
            }
        }
        System.out.println("No");
    }

    public static boolean dfs(int i, int j, int x, int rem, String[] s, int d) {
        if (rem == 0) return true;
        int[] dx = new int[]{-1,0,1,-1,1,-1,0,1};
        int[] dy = new int[]{-1,-1,-1,0,0,1,1,1};
        int ni = i + dx[d];
        int nj = j + dy[d];
        if (ni < 0 || ni >= s.length || nj < 0 || nj >= s.length) return false;
        if (s[ni].charAt(nj) == '#') {
            return dfs(ni, nj, x, rem-1, s, d);
        } else {
            if (x > 0) {
                return dfs(ni, nj, x-1, rem-1, s, d);
            } else {
                return false;
            }
        }
    }
}
