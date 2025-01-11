import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        
        long[] b = new long[n];
        int l=0;
        for (int r=1; r<n; r++) {
            b[r] = b[r-1];
            while (l<r) {
                if (a[r] * 0.5 >= a[l]) {
                    b[r]++;
                } else {
                    break;
                }
                l++;
            }
        }
        // for (int i=0; i<n; i++) {
        //     System.out.println(b[i]);
        // }
        long[] c = new long[n+1];
        c[0] = 0;
        for (int i=1; i<=n; i++) {
            c[i] = c[i-1] + b[i-1];
        }

        System.out.println(c[n]);
    }
}
