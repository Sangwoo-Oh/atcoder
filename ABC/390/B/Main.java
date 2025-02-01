import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextDouble();
        }

        double a0= a[0];
        double r = a[1] / a[0];
        double current = a0;
        for (int i=0; i<n; i++) {
            if (current == a[i]) {
                current *= r;
                continue;
            } else {
                // System.out.println(current + "," +  a[i]);
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
