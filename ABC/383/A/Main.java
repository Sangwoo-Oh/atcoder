import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int[] t = new int[n];
        int [] v = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = scanner.nextInt();
            v[i] = scanner.nextInt();
        }

        int sum = 0;
        int prev = t[0];
        for (int i = 0; i < n; i++) {
            if (i > 0 ) {
                sum = Math.max(sum - (t[i] - prev), 0) ;
            }
            sum += v[i];
            prev = t[i];
        }
        System.out.println(sum);
    }
}
