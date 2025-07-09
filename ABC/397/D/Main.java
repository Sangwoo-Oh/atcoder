import java.lang.*;
import java.util.*;

public class Main {
        static long sol(long a, long b, long c) {
        long l = 0, r = 600000001;
        while (r - l > 1) {
            long mid = (l + r) / 2;
            if (a * mid * mid + b * mid + c <= 0) {
                l = mid;
            } else {
                r = mid;
            }
        }
        if (a * l * l + b * l + c == 0) {
            return l;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        long n = scanner.nextLong();
        
        for (long d = 1; d*d*d < n; d++) {
            long c = (n-d*d*d);
            if (c % (3*d) == 0) continue;
            c /= 3*d;

            long y = ;
            if (y*y+d*y-c == 0) {
                System.out.println(y+d + " " + y);
                return;
            } 
        }
        
        System.out.println(-1);
    }
}
