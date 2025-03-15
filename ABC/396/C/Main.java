import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Integer[] b = new Integer[n];
        Integer[] w = new Integer[m];
        for (int i=0; i<n; i++) {
            b[i] = scanner.nextInt();
        }
        for (int i=0; i<m; i++) {
            w[i] = scanner.nextInt();
        }

        Arrays.sort(b, Collections.reverseOrder());
        Arrays.sort(w, Collections.reverseOrder());

        long[] bb = new long[n+1];
        long[] ww = new long[m+1];

        for (int i=0; i<n; i++) {
            bb[i+1] = bb[i] + b[i];
        }
        for (int i=0; i<m; i++) {
            ww[i+1] = ww[i] + w[i];
        }

        long[] ww_max = new long[m+1];
        for (int i=0; i<m; i++) {
            ww_max[i+1] = Math.max(ww_max[i], ww[i+1]);
        }
        
        long max = 0;
        for (int i=0; i<n; i++) {
            max = Math.max(max, bb[i+1] + ww_max[Math.min(i+1, m)]);
        }

        System.out.println(max);
    }
}
