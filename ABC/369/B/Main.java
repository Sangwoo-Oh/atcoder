import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int[] a = new int[n];
        char[] s = new char[n];
        for (int i=0; i<n; i++) {
            a[i] = scanner.nextInt();
            s[i] = scanner.next().charAt(0);
        }

        int ans = Integer.MAX_VALUE;
        for (int l=1; l<=100; l++) {
            for (int r=1; r<=100; r++) {
                int L=l, R=r;
                int t = 0;
                for (int i=0; i<n; i++) {
                    if (s[i] == 'L') {
                        t += Math.abs(L-a[i]);
                        L = a[i];
                    } else {
                        t += Math.abs(R-a[i]);
                        R = a[i];
                    }
                }
                ans = Math.min(ans, t);
            }
        } 
        System.out.println(ans);
    }
}
