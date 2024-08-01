import java.lang.*;
import java.util.*;

public class Main {
    static int h;
    static int w;
    static char[][] field;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        h = scanner.nextInt();
        w = scanner.nextInt();
        field = new char[h][w];
        for (int i=0; i<h; i++) {
            String s = scanner.next();
            for (int j=0; j<w; j++) {
                field[i][j]=s.charAt(j);
            }
        }
        int n = Math.min(h,w);
        int[] cnt = new int[n+1];
        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                if (isCenter(i,j)){
                    int[] judge = isX(i, j);
                    if (judge[0] == 1) {
                        cnt[judge[1]] += 1;
                    }
                }
            }
        }
        int k=0;
        for (int num : cnt) {
            k++;
            if (k==1) continue;
            System.out.print(num+" ");
        }
        System.out.println();
    }

    public static boolean isCenter(int x, int y) {
        if (x == 0 || x == h-1 || y == 0 || y == w-1) return false;

        int[] dx = new int[]{0,0,1,-1,1,-1,1,-1};
        int[] dy = new int[]{1,-1,0,0,1,-1,-1,1};

        for (int i = 0; i < 8; i++) {
            if (i < 4) {
                if (field[x+dx[i]][y+dy[i]] != '.') return false;
            } else {
                if (field[x+dx[i]][y+dy[i]] != '#') return false;
            }
        }

        return true;
    }

    public static int[] isX (int x, int y) {
        if (f(x,y,1,1) == f(x,y,-1,-1) && f(x,y,-1,1) == f(x,y,1,-1) && f(x,y,1,-1) == f(x,y,1,1) && f(x,y,1,1) > 0) {
            return new int[]{1, f(x,y,1,1)};
        } else {
            return new int[]{0, -1};
        }
    }
    public static int f(int x, int y, int dx, int dy){
        if (x+dx < 0 || x+dx >= h || y+dy < 0 || y+dy >= w) return 0;
        if (field[x+dx][y+dy] == '#') {
            return 1 + f(x+dx, y+dy, dx, dy);
        } else {
            return 0;
        }
    }
}
