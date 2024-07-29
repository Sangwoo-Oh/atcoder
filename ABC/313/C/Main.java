import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        long[] a = new long[n];
        for(int i = 0; i < n; i++) a[i]=scanner.nextLong();

        long s = Arrays.stream(a).sum();
        long x = s/n; long r = s%n;

        long[] b = new long[n];
        Arrays.fill(b, x);
        for (int i = 0; i < r; i++) b[i]++;

        Arrays.sort(a);
        Arrays.sort(b);
        long ans = 0;

        for (int i = 0; i < n; i++) {
            ans += Math.abs(a[i] - b[i]);
        }
        ans /= 2;

        System.out.println(ans);
    }
}
