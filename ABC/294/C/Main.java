import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);

        int[] A = new int[n];
        int[] B = new int[m];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n && j < m) {
            if (a[i] < b[j]) {
                A[i] = k+1;
                i++;
                k++;
            } else {
                B[j] = k+1;
                j++;
                k++;
            }
        }

        while (i < n) {
            A[i] = k+1;
            i++;
            k++;
        }
        while (j < m) {
            B[j] = k+1;
            j++;
            k++;
        }
        int l = 1;
        for (int x : A) {
            System.out.print(x);
            if (l < n) {
                System.out.print(" ");
            }
            l++;
        }
        l = 1;
        System.out.println();
        for (int x : B) {
            System.out.print(x);
            if (l < m) {
                System.out.print(" ");
            }
            l++;
        }
        System.out.println();
    }
}
