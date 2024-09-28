import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Set<Integer> a = new HashSet<>();
        for (int i = 0; i < k; i++) {
            a.add(scanner.nextInt()-1);
        }
        long[] x = new long[n];
        long[] y = new long[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextLong();
            y[i] = scanner.nextLong();
        }

        long max = Long.MIN_VALUE;
        for (int i=0; i<n; i++) {
            long min = Long.MAX_VALUE;
            if (a.contains(i)) {
                continue;
            }
            for (int j : a) {
                long d = Math.abs(x[i]-x[j])*Math.abs(x[i]-x[j]) + Math.abs(y[i]-y[j])*Math.abs(y[i]-y[j]);
                min = Math.min(min, d);
            }
            max = Math.max(max, min);
        }
        System.out.println(Math.sqrt(max));
    }
}
