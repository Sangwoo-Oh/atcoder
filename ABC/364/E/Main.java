import java.lang.*;
import java.util.*;

public class Main {
    static int ans;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        long x = scanner.nextLong();
        long y = scanner.nextLong();
        Long[] a = new Long[n];
        Long[] b = new Long[n];
        for (int i=0; i<n; i++) {
            a[i] = scanner.nextLong();
            b[i] = scanner.nextLong();
        }

        int[][][] dp = new int[n+1][x+1][y+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

            }
        }

    }
}
