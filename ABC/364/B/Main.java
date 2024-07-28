import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        int sx = scanner.nextInt()-1;
        int sy = scanner.nextInt()-1;

        String[] c = new String[h];
        for (int i=0; i<h; i++) {
            c[i] = scanner.next();
        }
        String x = scanner.next();

        int[] dx = new int[] {0,0,-1,1};
        int[] dy = new int[] {-1,1,0,0};

        for (char xx : x.toCharArray()) {
            int nx, ny;
            int j = 0;
            if (xx=='L') {
                j = 0;
            } else if (xx=='R') {
                j = 1;
            } else if (xx=='U') {
                j = 2;
            } else if (xx=='D') {
                j = 3;
            }
            nx = sx + dx[j];
            ny = sy + dy[j];
            if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
            if (c[nx].charAt(ny) == '#') continue;

            sx = nx;
            sy = ny;
        }

        System.out.println((sx+1) + " " + (sy+1));
    }
}
