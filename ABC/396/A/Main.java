import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int[] a = new int[n];

        for (int i=0; i<n; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i=0; i<n-2; i++) {
            if (a[i] == a[i+1] && a[i+1] == a[i+2]) {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");

    }
}
