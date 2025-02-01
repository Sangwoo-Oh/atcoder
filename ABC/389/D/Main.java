import java.lang.*;
import java.util.*;

class Point {
    double x;
    double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        long r = scanner.nextLong();

        // minimum number of squares
        long ans = 1;
        
        // if r is greater than 1, we need to add more squares
        ans += (r-1) * 4;
        long tmp = 0;
        long x = r;
        long y = 2;
        while(x >= 2) {
            while (y <= r) {
                if ((0.5-x)*(0.5-x) + (0.5-y)*(0.5-y) <= r*r) {
                    tmp += (x-1);
                    y++;
                } else {
                    break;
                }
            }
            x--;
        }
        ans += tmp * 4;
        System.out.println(ans);
    }
}
