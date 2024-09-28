import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        long N = scanner.nextLong();
        long a = scanner.nextLong()-1;
        long b = scanner.nextLong()-1;
        long p = scanner.nextLong()-1;
        long q = scanner.nextLong()-1;
        long r = scanner.nextLong()-1;
        long s = scanner.nextLong()-1;

        int n = (int)(q-p+1);
        int m = (int)(s-r+1);
        char[][] ans = new char[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ans[i], '.');
        }

        // operation 1
        long lower = Math.max(1-a, 1-b);
        long upper = Math.min(N-a, N-b);
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                long ii = i+p;
                long jj = j+r;
                if (ii+jj == a + b) {
                    ans[i][j] = '#';
                }
            }
        }

        // operation 2
        lower = Math.max(1-a, b-N);
        upper = Math.min(N-a, b-1);
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                long ii = i+p;
                long jj = j+r;
                if (ii-jj == a - b) {
                    ans[i][j] = '#';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(new String(ans[i]));
        }
    }
}
