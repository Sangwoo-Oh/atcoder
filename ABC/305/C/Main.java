import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        char[][] field = new char[h][w];
        for (int i=0; i<h; i++) {
            String s = scanner.next();
            for (int j=0; j<w; j++) {
                field[i][j]=s.charAt(j);
            }
        }

        int u = Integer.MAX_VALUE;
        int d = Integer.MIN_VALUE;
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (field[i][j] == '#') {
                    u = Math.min(u, i); d = Math.max(d, i);
                    l = Math.min(l, j); r = Math.max(r, j);
                }
            }
        }

        for (int i = u; i <= d; i++) {
            for (int j = l; j <= r; j++) {
                if (field[i][j] == '.') System.out.println((i+1)+" "+(j+1));
            }
        }
    }
}
