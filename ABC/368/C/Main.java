import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        long[] h = new long[n];
        for (int i=0; i<n; i++) h[i] = scanner.nextLong();

        long t = 0;
        for (int i=0; i<n; i++) {
            if(h[i] >= 5) {
                t += (h[i] / 5)*3;
                h[i] -= 5 * (h[i] / 5);
            }
            while (h[i] > 0) {
                t++;
                if (t%3==0) {
                    h[i] -= 3;
                } else {
                    h[i] -= 1;
                }
            }
        }
        System.out.println(t);
    }
}
