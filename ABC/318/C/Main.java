import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        long p = scanner.nextLong();
        Long[] f = new Long[n]; for (int i = 0; i < n; i++) f[i] = scanner.nextLong();

        Arrays.sort(f, Collections.reverseOrder());
        long ans = 0;
        long dPrice = 0;
        for (int i = 0; i < n && i < d; i++) dPrice += f[i];
        for (int i = 0; i < n; i++) {
            if (p < dPrice) {
                ans += p;
                i += d-1;
                dPrice = 0;
                for (int j = 0; i+j+1 < n && j < d; j++) {
                    dPrice += f[i+j+1];
                }
            } else {
                ans += f[i];
                dPrice -= f[i];
                if (i+d < n) dPrice += f[i+d];
            }
        }
        System.out.println(ans);
    }
}
