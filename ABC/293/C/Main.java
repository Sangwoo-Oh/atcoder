import java.lang.*;
import java.util.*;

public class Main {
    static int h;
    static int w;
    static int[][] a;
    static int ans;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        h = scanner.nextInt();
        w = scanner.nextInt();
        a = new int[h][w];
        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        HashSet<Integer> set = new HashSet<>();
        set.add(a[0][0]);
        dfs(0,0,set);
        System.out.println(ans);
    }

    private static void dfs(int i, int j, HashSet<Integer> set) {
        if (i==h-1 && j==w-1) {
            ans++; return;
        }
        int[] dx = new int[]{0,1};
        int[] dy = new int[]{1,0};
        for (int k=0; k<2; k++) {
            int nx = i+dx[k];
            int ny = j+dy[k];
            if (nx<0 || nx>=h || ny<0 || ny>=w) continue;
            if (!set.add(a[nx][ny])) continue;
            dfs(nx, ny, set);
            set.remove(a[nx][ny]);
        }
    }
}
