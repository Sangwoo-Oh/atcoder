import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int[] a = new int[n];
        long cnt = 0;
        for (int i=1; i<=n; i++) {
            a[i-1] = scanner.nextInt();
            if(a[i-1]==i) cnt++;
        }

        long ans = (cnt*(cnt-1))/2;

        for (int i=0; i<n; i++) {
            if(a[i]==i+1) continue;
            if(a[a[i]-1]==i+1 && i<a[i]-1) ans++;
        }

        System.out.println(ans);
    }
}
