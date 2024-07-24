import java.lang.*;
import java.util.*;

public class Main {
    static int h;
    static int w;
    static char[][] field;
    static boolean[][] detected;
    static int[] dx = new int[] {1, 0 ,-1, 0, 1, -1, 1, -1};
    static int[] dy = new int[] {0, 1, 0 ,-1, 1, -1, -1, 1};

    static void dfs(int x, int y) {
        detected[x][y] = true;

        for (int k=0; k<8; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
            if (field[nx][ny] == '.') continue;
            if (detected[nx][ny]) continue;

            dfs(nx, ny);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        h = scanner.nextInt();
        w = scanner.nextInt();
        field = new char[h][w];
        for (int i = 0; i < h; i++) {
            String s = scanner.next();
            for (int j = 0; j < w; j++) field[i][j] = s.charAt(j);
        }

        detected = new boolean[h][w];

        int cnt = 0;
        for (int i = 0; i < h; i++) for (int j = 0; j < w; j++) {
            if (field[i][j] == '.') continue;
            if (detected[i][j]) continue;
            dfs(i,j);
            cnt++;
        }
        System.out.println(cnt);
    }
}
