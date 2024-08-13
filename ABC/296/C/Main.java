import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        long x = scanner.nextLong();
        HashSet<Long> set = new HashSet<>();
        long[] a = new long[n];
        for (int i=0; i<n; i++) {
            a[i] = scanner.nextLong();
            set.add(a[i]+x);
        }

        for (int i=0; i<n; i++) {
            if(set.contains(a[i])) {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }
}
