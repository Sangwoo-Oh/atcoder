import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        long[] k = new long[n];
        for (int i=0; i<n; i++) {
            k[i] = scanner.nextLong();
        }
        // bit all search
        // 1->group A, 0->group B

        long min = Long.MAX_VALUE;
        for (int bit=0; bit<(1<<n); bit++) {
            ArrayList<Long> a = new ArrayList<Long>();
            ArrayList<Long> b = new ArrayList<Long>();
            for (int i=0; i<n; i++) {
                if ((bit & (1<<i)) != 0) {
                    a.add(k[i]);
                } else {
                    b.add(k[i]);
                }
            }

            long sumA = a.stream().mapToLong(Long::longValue).sum();
            long sumB = b.stream().mapToLong(Long::longValue).sum();

            long max = Math.max(sumA, sumB);

            min = Math.min(min, max);
        }

        System.out.println(min);
    }   
}
