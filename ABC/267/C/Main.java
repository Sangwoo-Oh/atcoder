import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /* input */
        int n = scanner.nextInt();
		int m = scanner.nextInt();
		long[] a = new long[n];
		for (int i=0; i<n; i++) a[i] = scanner.nextLong();

		long now = 0;
		for (int i=0; i<m; i++) now += a[i]*(i+1);
		long diff = 0;
		for (int i=1; i<m; i++) diff += a[i];

		long ans = now;
		for (int i=1; i<n-m+1; i++) {
			now -= a[i-1];
			now -= diff;
			now += a[i+m-1]*m;

			ans = Math.max(ans, now);

			//adjust diff
			diff -= a[i];
			diff += a[i+m-1];
		}

		System.out.println(ans);
	}
}
