import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int[] q = new int[n];
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            q[i] = scanner.nextInt();
            r[i] = scanner.nextInt();
        }

        int Q = scanner.nextInt();
        for (int i = 0; i < Q; i++) {
            int t = scanner.nextInt() - 1;
            int d = scanner.nextInt();

            if (d == r[t]) {
                System.out.println(d);
            } else {
                if (d < r[t]) {
                    System.out.println(r[t]);
                } else {
                    int rem = d % q[t];
                    if (rem == r[t]) {
                        System.out.println(d);
                    } else {
                        if (rem < r[t]) {
                            System.out.println(r[t] - rem + d);
                        } else {
                            System.out.println(q[t] - 1 - d % q[t] + r[t] + 1 + d);
                        }
                    }
                }
            }
        } 
    }
}
