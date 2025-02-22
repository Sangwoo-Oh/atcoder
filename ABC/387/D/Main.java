import java.lang.*;
import java.util.*;

public class Main {
    static int h;
    static int w;
    static char[][] mtx;
    static int[][] dist;
    static Queue<int[]> q;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        h = scanner.nextInt();
        w = scanner.nextInt();
        mtx = new char[h][w];

        for (int i=0; i<h; i++) {
            String s = scanner.next();
            for (int j=0; j<w; j++) {
                mtx[i][j] = s.charAt(j);
            }
        }

        int ans = 100100100;
        for (int par=0; par<2; par++) {
            dist = new int[h][w];
            for (int[] d: dist) { Arrays.fill(d, Integer.MAX_VALUE); }            
            q = new LinkedList<>();

            for (int i=0; i<h; i++) {
                for (int j=0; j<w; j++) {
                    if (mtx[i][j] == 'S') {
                        q.add(new int[]{i,j});
                        dist[i][j] = 0;
                    }
                }
            }

            while(!q.isEmpty()) {
                int[] node = q.poll();
                int i = node[0]; int j = node[1];
                int d = dist[i][j];
                if (mtx[i][j] == 'G') ans = Math.min(ans, d);
                if ((i+j)%2 == par) {
                    push(i+1,j,d);
                    push(i-1,j,d);
                } else {
                    push(i,j+1,d);
                    push(i,j-1,d);
                }
            }
        }
        if (ans == 100100100) ans = -1;
        System.out.println(ans);
    }

    static public void push(int i,int j,int d) {
        if (i < 0 || j < 0 || i >= h || j >= w) {return;}
        if (dist[i][j] < Integer.MAX_VALUE){return;}
        if (mtx[i][j] == '#') {return;}
        q.add(new int[]{i,j});
        dist[i][j] = d+1; 
    }
}
