import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* input */
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] a = new int[n];
        for(int i=0; i<m; i++) {
            int x = scanner.nextInt() - 1;
            a[x] = 1;
        }

        int[] b = new int[n];
        for (int i = n-1; i >= 0; i--) {
            if (a[i] == 1) b[i] = 0;
            else b[i] = b[i+1] + 1;
        }

        for (int num : b) System.out.println(num);
    }
}
