import java.lang.*;
import java.util.*;

public class Main {
    static int h;
    static int w;
    static int[] dx;
    static int[] dy;
    static boolean[][] detected;

    static void dfs(String[] field, int x, int y) {
        detected[x][y] = true;

        for (int direction = 0; direction < 4; direction++) {
            int next_x = x + dx[direction];
            int next_y = y + dy[direction];

            if (next_x < 0 || next_x >= h || next_y < 0 || next_y >= w) continue;
            if (field[next_x].charAt(next_y) == '#') continue;
            if (detected[next_x][next_y]) continue;
            dfs(field, next_x, next_y);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        h = scanner.nextInt();
        w = scanner.nextInt();

        String[] field = new String[h];
        for (int i = 0; i < h; i++) field[i] = scanner.next();

        int sx = 0, sy = 0, gx = 0, gy = 0;
        for (int i = 0; i < h; i++) for (int j = 0; j < w; j++) {
            if (field[i].charAt(j) == 's') {sx = i; sy = j;}
            if (field[i].charAt(j) == 'g') {gx = i; gy = j;}
        }


        dx = new int[] {1, 0, -1, 0};
        dy = new int[] {0, 1, 0, -1};
        detected = new boolean[h][w];
        dfs(field, sx,sy);

        if(detected[gx][gy]) System.out.println("Yes");
        else System.out.println("No");
    }
}
