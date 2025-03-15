import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        long s = scanner.nextLong();
        long[] a = new long[n];
        long[] b = new long[(n*2)+1];
        for (int i=0; i<n; i++) {
            a[i] = scanner.nextLong();
        }
        for (int i=0; i<2*n; i++) {
            b[i+1] = b[i] + a[i%n]; 
        }

        long T = b[n];
        s = s % T;
        HashSet<Long> set = new HashSet<>();
        for (int i=0; i<2*n; i++) {
            set.add(b[i]);
        }
        for (int i=0; i<2*n; i++) {
            if (set.contains(b[i]-s)) {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }
}
