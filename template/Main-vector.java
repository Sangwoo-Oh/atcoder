import java.lang.*;
import java.util.*;

class V {
    int x, y;
    public V(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public V subtract(V other) {
        return new V(this.x - other.x, this.y - other.y);
    }

    // cross product
    public int cross(V v) {
        return this.x*v.y - this.y*v.x;
    }
    // counter clockwise: 1, clockwise: -1, colinear: 0
    public int ccw(V v) {
        int area = this.cross(v);
        if (area>0) return 1;
        if (area<0) return -1;
        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        ArrayList<V> p = new ArrayList<>();
        for (int i=0; i<4; i++) {
            p.add(new V(scanner.nextInt(), scanner.nextInt()));
        }
        for (int i=0; i<4; i++) {
            V A = p.get(i);
            V B = p.get((i+1)%4);
            V C = p.get((i+2)%4);
            V b = B.subtract(A), c = C.subtract(A);
            if (b.ccw(c)!=1) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
