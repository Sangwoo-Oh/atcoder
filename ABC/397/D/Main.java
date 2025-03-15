import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        long n = scanner.nextLong();
        
        for (long y = 1; y<=1e9; y++) {
            Double x = Math.cbrt(n+y*y*y);
            if (((((long)x)*((long)x)*((long)x))) == (n+(y*y*y))) {
                System.out.println(x);
                System.out.println((long)(x*x*x) + " " + (n+y*y*y));
                System.out.println(x + " " + y);
                return;
            }
        }
        
        System.out.println(-1);
    }
}
