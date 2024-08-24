import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        Integer[] a = new Integer[n];
        for (int i=0; i<n; i++) {
            a[i] = scanner.nextInt();
        }

        int ans = 0;
        while(true) {
            ans++;
            Arrays.sort(a, Collections.reverseOrder());
            a[0]--;
            a[1]--;

            int cnt=0;
            for (int i=0; i<n; i++) {
                if (a[i] > 0) cnt++;
            }
            if (cnt <= 1) {
                System.out.println(ans);
                return;
            }
        }
    }
}
