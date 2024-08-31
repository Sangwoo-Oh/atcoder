import java.lang.*;
import java.util.*;

class Pos implements Comparable<Pos> {
    int x;
    int y;
    char d;
    Pos(int x, int y, char d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }

    @Override
    public int compareTo(Pos p) {
        if (this.y == p.y) {
            return this.x - p.x;
        }
        return this.y - p.y;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d, %c)", x, y, d);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int[] X = new int[n];
        int[] Y = new int[n];
        for (int i = 0; i < n; i++) {
            X[i] = scanner.nextInt();
            Y[i] = scanner.nextInt();
        }
        String s = scanner.next();

        Pos[] pos = new Pos[n];
        for (int i=0; i<n; i++) {
            pos[i] = new Pos(X[i], Y[i], s.charAt(i));
        }

        Collections.sort(Arrays.asList(pos));

        int y = pos[0].y;
        char d = pos[0].d;
        for (int i=1; i<n; i++) {
            if (pos[i].y == y) {
                if (d == 'R') {
                    if (pos[i].d == 'L') {
                        System.out.println("Yes");
                        return;
                    }
                }
                if (d == 'L') {
                    if (pos[i].d == 'R') {
                        d = 'R';
                    }
                }
            } else {
                y = pos[i].y;
                d = pos[i].d;
            }
        }
        System.out.println("No");
    }
}
