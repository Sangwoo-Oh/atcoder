import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i=n-k; i<n+n-k; i++) {
            System.out.print(a[i%n] + " ");
        }
        System.out.println();


    }
}
