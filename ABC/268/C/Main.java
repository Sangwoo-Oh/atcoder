import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int[] p = new int[n];
        for(int i=0; i<n; i++) {
            p[i] = scanner.nextInt();
        }

        int[] cnt = new int[n];
        for (int i=0; i<n; i++) {
            int j = (p[i]-i-1+n)%n;
            for (int k=0;k<3;k++) {
                cnt[(j+k)%n]++;
            }
        }
        int ans = 0;
        for (int i=0; i<n; i++) {
            ans = Math.max(ans, cnt[i]);
        }
        System.out.println(ans);
    }
}
